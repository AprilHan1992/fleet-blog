package com.fleet.consumer.controller.open.article;

import com.fleet.common.entity.article.Tag;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.article.TagService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController("OpenTagController")
@RequestMapping("/open/tag")
public class TagController {

    @Reference
    private TagService tagService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("tagId") Integer tagId) {
        Tag tag = new Tag();
        tag.setTagId(tagId);
        return R.ok(tagService.get(tag));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(tagService.list(map));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<Tag> listPage(@RequestBody Page page) {
        return tagService.listPage(page);
    }

}
