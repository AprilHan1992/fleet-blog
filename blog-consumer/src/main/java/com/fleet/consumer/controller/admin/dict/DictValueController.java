package com.fleet.consumer.controller.admin.dict;

import com.fleet.common.entity.dict.Value;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.dict.ValueService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dict/value")
public class DictValueController {

    @Reference
    private ValueService valueService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody Value dictValue) {
        valueService.insert(dictValue);
        return R.ok();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("id") Integer id) {
        Value dictValue = new Value();
        dictValue.setId(id);
        valueService.delete(dictValue);
        return R.ok();
    }

    @RequestMapping(value = "/deletes", method = {RequestMethod.GET, RequestMethod.POST})
    public R deletes(@RequestParam("ids") List<Integer> ids) {
        for (Integer id : ids) {
            Value dictValue = new Value();
            dictValue.setId(id);
            valueService.delete(dictValue);
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody Value dictValue) {
        valueService.update(dictValue);
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("id") Integer id) {
        Value dictValue = new Value();
        dictValue.setId(id);
        return R.ok(valueService.get(dictValue));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(valueService.list(map));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<Value> listPage(@RequestBody Page page) {
        return valueService.listPage(page);
    }

}
