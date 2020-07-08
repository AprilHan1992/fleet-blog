package com.fleet.provider.blog;

import com.fleet.common.entity.article.Tag;
import com.fleet.common.service.article.TagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

//@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagServiceTests {

    @Resource
    private TagService tagService;

    @Test
    public void insert() {
        Tag tag = new Tag();
        tag.setType(1);
        tag.setTag("心情日记");
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
        Integer[] ids = {1, 2, 3};
        tagService.deletes(ids);
    }
}
