package com.fleet.consumer.controller.admin.dict;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.dict.Dict;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.dict.DictService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody Dict dict) {
        if (!dictService.update(dict)) {
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("id") Integer id) {
        Dict dict = new Dict();
        dict.setId(id);
        return R.ok(dictService.get(dict));
    }

    @RequestMapping(value = "/getDefaultValue", method = RequestMethod.GET)
    public String getDefaultValue(@RequestParam("group") String group) {
        return dictService.getDefaultValue(group);
    }

    @RequestMapping(value = "/getValue", method = RequestMethod.GET)
    public String getValue(@RequestParam("group") String group, @RequestParam("code") String code) {
        return dictService.getValue(group, code);
    }
}
