package com.fleet.consumer.controller.blog.sys.dict;

import com.fleet.common.entity.dict.DictValue;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.dict.DictValueService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("OpenDictValueController")
@RequestMapping("/open/dict/value")
public class DictValueController {

    @Reference
    private DictValueService dictValueService;

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
