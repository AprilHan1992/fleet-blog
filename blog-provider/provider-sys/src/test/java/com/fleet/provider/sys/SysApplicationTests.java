package com.fleet.provider.sys;

import com.fleet.common.entity.dict.Dict;
import com.fleet.common.service.dept.DeptService;
import com.fleet.common.service.dict.DictService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysApplicationTests {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DictService dictService;

    @Test
    public void deptId() {
        Integer deptId = deptService.getDeptId("财务部/会计");
        System.out.println(deptId);
    }


    @Test
    public void deptIdList() {
        List<Integer> list = deptService.deptIdList(1);
        System.out.println(list);
    }

    @Test
    public void insert() {
        Dict dict = new Dict();
        dict.setDictGroup("测试1");
        dict.setDictRemark("测试");
        dictService.insert(dict);
    }

}
