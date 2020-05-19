package com.fleet.common.aspect;

import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * 自动分页AOP拦截器（service方法名要带后缀Page，参数中要带Page page，否则会按照正常处理）
 */
public class PageAspect {

    @Around("execution(* com.fleet.common.service..*.*Page(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 获取连接点方法运行时的入参列表
        Object[] args = pjp.getArgs();
        Page page = null;
        if (args.length > 0) {
            for (Object arg : args) {
                if (arg instanceof Page) {
                    page = (Page) arg;
                    break;
                }
            }
        }

        if (page != null) {
            PageHelper.startPage(page.getPageIndex(), page.getPageRows());
            try {
                PageUtil<?> pageUtil = (PageUtil<?>) pjp.proceed();
                PageInfo<?> pageInfo = new PageInfo<>(pageUtil.getList());
                page.setTotalRows((int) pageInfo.getTotal());
                pageUtil.setPage(page);
                return pageUtil;
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                return pjp.proceed();
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
