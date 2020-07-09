package com.fleet.consumer.controller.admin.dict;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.dict.Dict;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.dict.DictService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 字典与字典值管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController<Dict> {

    @Reference
    private DictService dictService;

    @Override
    public BaseService<Dict> baseService() {
        return dictService;
    }

    @Override
    @PostMapping("/insert")
    public R insert(@RequestBody Dict dict) {
        Dict d = new Dict();
        d.setGroup(dict.getGroup());
        d = dictService.get(d);
        if (d != null) {
            return R.error("字典组已存在");
        }
        if (!dictService.insert(dict)) {
            return R.error();
        }
        return R.ok();
    }

    @Override
    @PostMapping("/update")
    public R update(@RequestBody Dict dict) {
        Dict d = new Dict();
        d.setGroup(dict.getGroup());
        d = dictService.get(d);
        if (d != null && !d.getId().equals(dict.getId())) {
            return R.error("字典组已存在");
        }
        if (!dictService.update(dict)) {
            return R.error();
        }
        return R.ok();
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Integer id) {
        Dict dict = new Dict();
        dict.setId(id);
        return get(dict);
    }

    @GetMapping("/getDefaultValue")
    public String getDefaultValue(@RequestParam("group") String group) {
        return dictService.getDefaultValue(group);
    }

    @GetMapping("/getValue")
    public String getValue(@RequestParam("group") String group, @RequestParam("code") String code) {
        return dictService.getValue(group, code);
    }
}
