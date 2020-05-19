package com.fleet.provider.article;

import com.fleet.common.entity.article.Tag;
import com.fleet.common.service.article.TagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagServiceTests {

    @Autowired
    private TagService tagService;

    @Test
    public void insert() {
        Tag tag = new Tag();
        tag.setTagType(1);
        tag.setTag("心情日记");
        tagService.insert(tag);
    }

}