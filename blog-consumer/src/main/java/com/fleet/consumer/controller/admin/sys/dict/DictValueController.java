package com.fleet.consumer.controller.admin.sys.dict;

import com.fleet.common.entity.dict.DictValue;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.dict.DictValueService;
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
    private DictValueService dictValueService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody DictValue dictValue) {
        dictValueService.insert(dictValue);
        return R.ok();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("dictValueId") Integer dictValueId) {
        DictValue dictValue = new DictValue();
        dictValue.setDictValueId(dictValueId);
        dictValueService.delete(dictValue);
        return R.ok();
    }

    @RequestMapping(value = "/delete/batch", method = {RequestMethod.GET, RequestMethod.POST})
    public R deleteBatch(@RequestParam("dictValueIds") List<Integer> dictValueIds) {
        for (Integer dictValueId : dictValueIds) {
            DictValue dictValue = new DictValue();
            dictValue.setDictValueId(dictValueId);
            dictValueService.delete(dictValue);
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody DictValue dictValue) {
        dictValueService.update(dictValue);
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("dictValueId") Integer dictValueId) {
        DictValue dictValue = new DictValue();
        dictValue.setDictValueId(dictValueId);
        return R.ok(dictValueService.get(dictValue));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(dictValueService.list(map));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<DictValue> listPage(@RequestBody Page page) {
        return dictValueService.listPage(page);
    }

}
