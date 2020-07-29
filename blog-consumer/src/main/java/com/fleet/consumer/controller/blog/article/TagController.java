package com.fleet.consumer.controller.blog.article;

import com.fleet.common.entity.article.Tag;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.article.TagService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("BlogTagController")
@RequestMapping("/blog/tag")
public class TagController {

    @Reference
    private TagService tagService;

    @GetMapping("/get")
    public R get(@RequestParam("id") Long id) {
        Tag tag = new Tag();
        tag.setId(id);
        return R.ok(tagService.get(tag));
    }

    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(tagService.list(map));
    }

    @PostMapping("/listPage")
    public PageUtil<Tag> listPage(@RequestBody Page page) {
        return tagService.listPage(page);
    }
}
