package com.fleet.provider.blog;

import com.alibaba.fastjson.JSON;
import com.fleet.common.entity.article.Tag;
import com.fleet.common.service.article.TagService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagServiceTests {

    @Resource
    private TagService tagService;

    @Test
    public void insert() {
        Tag tag = new Tag();
        tag.setType(1);
        tag.setTag("测试类型");
        tagService.insert(tag);
    }

    @Test
    public void delete() {
        Tag tag = new Tag();
        tag.setId(1);
        tagService.delete(tag);
    }

    @Test
    public void deletes() {
        Tag tag = new Tag();
        tag.setId(1);
        tag.setTag("修改类型");
        tagService.update(tag);
    }

    @Test
    public void update() {
        Integer[] ids = {1, 2, 3};
        tagService.deletes(ids);
    }

    @Test
    public void get() {
        Tag tag = new Tag();
        tag.setId(1);
        tag = tagService.get(tag);
        System.out.println(JSON.toJSONString(tag));
    }

    @Test
    public void list() {
        Map<String, Object> map = new HashMap<>();
        List<Tag> list = tagService.list(map);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void listPage() {
        Page page = new Page();
        page.setPageRows(2);
        PageUtil<Tag> pageUtil = tagService.listPage(page);
        System.out.println(JSON.toJSONString(pageUtil));
    }
}
