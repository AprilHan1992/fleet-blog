package com.fleet.consumer.controller.admin.article;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.article.Tag;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.article.TagService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 标签管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/tag")
public class TagController extends BaseController<Tag> {

    @Reference
    private TagService tagService;

    @Override
    public BaseService<Tag> baseService() {
        return tagService;
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Integer id) {
        Tag tag = new Tag();
        tag.setId(id);
        return get(tag);
    }
}
