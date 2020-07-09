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
        dept.setUpperId(1);
        dept.setCreatorId(1);
        dept.setCreateTime(new Date());
        deptService.insert(dept);
    }

    @Test
    public void delete() {
        Dept dept = new Dept();
        dept.setId(1);
        deptService.delete(dept);
    }

    @Test
    public void deletes() {
        Integer[] ids = {1, 2, 3};
        deptService.deletes(ids);
    }

    @Test
    public void update() {
        Dept dept = new Dept();
        dept.setId(1);
        dept.setName("修改项目部");
        deptService.update(dept);
    }

    @Test
    public void get() {
        Dept dept = new Dept();
        dept.setId(3);
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
        Integer deptId = deptService.getId("项目部/项目一部");
        System.out.println(JSON.toJSONString(deptId));
    }


    @Test
    public void idList() {
        List<Integer> list = deptService.idList(1);
        System.out.println(JSON.toJSONString(list));
    }
}
