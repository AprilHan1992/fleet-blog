package com.fleet.consumer.controller.blog.sys.dict;

import com.fleet.common.entity.dict.Dict;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.dict.DictService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("OpenDictController")
@RequestMapping("/open/dict")
public class DictController {

    @Reference
    private DictService dictService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("dictId") Integer dictId) {
        Dict dict = new Dict();
        dict.setDictId(dictId);
        return R.ok(dictService.get(dict));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(dictService.list(map));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<Dict> listPage(@RequestBody Page page) {
        return dictService.listPage(page);
    }

    @RequestMapping(value = "/getDefaultValue", method = RequestMethod.GET)
    public String getDefaultValue(@RequestParam("dictGroup") String dictGroup) {
        return dictService.getDefaultValue(dictGroup);
    }

    @RequestMapping(value = "/getValue", method = RequestMethod.GET)
    public String getValue(@RequestParam("dictGroup") String dictGroup, @RequestParam("dictValueCode") String dictValueCode) {
        return dictService.getValue(dictGroup, dictValueCode);
    }

}
