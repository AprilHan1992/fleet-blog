package com.fleet.provider.admin;

import com.fleet.common.entity.dict.Dict;
import com.fleet.common.service.dept.DeptService;
import com.fleet.common.service.dict.DictService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {

    @Resource
    private DeptService deptService;

    @Resource
    private DictService dictService;

    @Test
    public void insert() {
        Dict dict = new Dict();
        dict.setGroup("测试1");
        dict.setRemark("测试");
        dictService.insert(dict);
    }
}
