package com.fleet.provider.admin;

import com.alibaba.fastjson.JSON;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.service.dept.DeptService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptServiceTests {

    @Resource
    private DeptService deptService;

    @Test
    public void insert() {
        Dept dept = new Dept();
        dept.setName("项目一部");
        dept.setUpperId(1L);
        dept.setCreatorId(1L);
        dept.setCreateTime(new Date());
        deptService.insert(dept);
    }

    @Test
    public void delete() {
        Dept dept = new Dept();
        dept.setId(1L);
        deptService.delete(dept);
    }

    @Test
    public void deletes() {
        Long[] ids = {1L, 2L, 3L};
        deptService.deletes(ids);
    }

    @Test
    public void update() {
        Dept dept = new Dept();
        dept.setId(1L);
        dept.setName("修改项目部");
        deptService.update(dept);
    }

    @Test
    public void get() {
        Dept dept = new Dept();
        dept.setId(3L);
        dept = deptService.get(dept);
        System.out.println(JSON.toJSONString(dept));
    }

    @Test
    public void list() {
        Map<String, Object> map = new HashMap<>();
        List<Dept> list = deptService.list(map);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void listPage() {
        Page page = new Page();
        page.setPageRows(2);
        PageUtil<Dept> pageUtil = deptService.listPage(page);
        System.out.println(JSON.toJSONString(pageUtil));
    }

    @Test
    public void deptId() {
        Long deptId = deptService.getId("项目部/项目一部");
        System.out.println(JSON.toJSONString(deptId));
    }


    @Test
    public void idList() {
        List<Long> list = deptService.idList(1L);
        System.out.println(JSON.toJSONString(list));
    }
}
