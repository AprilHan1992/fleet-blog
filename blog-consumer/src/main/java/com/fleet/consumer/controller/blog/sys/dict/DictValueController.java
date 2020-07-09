//package com.fleet.consumer.controller.blog.sys.dict;
//
//import com.fleet.common.entity.dict.Value;
//import com.fleet.common.enums.Deleted;
//import com.fleet.common.json.R;
//import com.fleet.common.service.dict.ValueService;
//import com.fleet.common.util.jdbc.PageUtil;
//import com.fleet.common.util.jdbc.entity.Page;
//import org.apache.dubbo.config.annotation.Reference;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController("OpenDictValueController")
//@RequestMapping("/open/dict/value")
//public class DictValueController {
//
//    @Reference
//    private ValueService valueService;
//
//    @RequestMapping(value = "/get", method = RequestMethod.GET)
//    public R get(@RequestParam("dictValueId") Integer dictValueId) {
//        Value dictValue = new Value();
//        dictValue.setId(dictValueId);
//        return get(dictValue);
//    }
//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public R list(@RequestParam Map<String, Object> map) {
//        map.put("deleted", Deleted.NO);
//        return R.ok(valueService.list(map));
//    }
//
//    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
//    public PageUtil<Value> listPage(@RequestBody Page page) {
//        return valueService.listPage(page);
//    }
//
//}
