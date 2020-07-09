//package com.fleet.provider.admin;
//
//import com.alibaba.fastjson.JSON;
//import com.fleet.common.entity.dict.Dict;
//import com.fleet.common.service.dict.DictService;
//import com.fleet.common.util.jdbc.PageUtil;
//import com.fleet.common.util.jdbc.entity.Page;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DictServiceTests {
//
//    @Resource
//    private DictService dictService;
//
//    @Test
//    public void insert() {
//        Dict dict = new Dict();
//        dict.setName("项目一部");
//        dict.setUpperId(1);
//        dict.setCreatorId(1);
//        dict.setCreateTime(new Date());
//        dictService.insert(dict);
//    }
//
//    @Test
//    public void delete() {
//        Dict dict = new Dict();
//        dict.setId(1);
//        dictService.delete(dict);
//    }
//
//    @Test
//    public void deletes() {
//        Integer[] ids = {1, 2, 3};
//        dictService.deletes(ids);
//    }
//
//    @Test
//    public void update() {
//        Dict dict = new Dict();
//        dict.setId(1);
//        dict.setName("修改项目部");
//        dictService.update(dict);
//    }
//
//    @Test
//    public void get() {
//        Dict dict = new Dict();
//        dict.setId(3);
//        dict = dictService.get(dict);
//        System.out.println(JSON.toJSONString(dict));
//    }
//
//    @Test
//    public void list() {
//        Map<String, Object> map = new HashMap<>();
//        List<Dict> list = dictService.list(map);
//        System.out.println(JSON.toJSONString(list));
//    }
//
//    @Test
//    public void listPage() {
//        Page page = new Page();
//        page.setPageRows(2);
//        PageUtil<Dict> pageUtil = dictService.listPage(page);
//        System.out.println(JSON.toJSONString(pageUtil));
//    }
//
//    @Test
//    public void dictId() {
//        Integer dictId = dictService.getId("项目部/项目一部");
//        System.out.println(JSON.toJSONString(dictId));
//    }
//
//
//    @Test
//    public void dictIdList() {
//        List<Integer> list = dictService.idList(1);
//        System.out.println(JSON.toJSONString(list));
//    }
//}
