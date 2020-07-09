//package com.fleet.consumer.controller.blog.sys.dict;
//
//import com.fleet.common.entity.dict.Dict;
//import com.fleet.common.enums.Deleted;
//import com.fleet.common.json.R;
//import com.fleet.common.service.dict.DictService;
//import com.fleet.common.util.jdbc.PageUtil;
//import com.fleet.common.util.jdbc.entity.Page;
//import org.apache.dubbo.config.annotation.Reference;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController("OpenDictController")
//@RequestMapping("/open/dict")
//public class DictController {
//
//    @Reference
//    private DictService dictService;
//
//    @GetMapping("/get")
//    public R get(@RequestParam("dictId") Integer dictId) {
//        Dict dict = new Dict();
//        dict.setDictId(dictId);
//        return get(dict);
//    }
//
//    @GetMapping("/list")
//    public R list(@RequestParam Map<String, Object> map) {
//        map.put("deleted", Deleted.NO);
//        return R.ok(dictService.list(map));
//    }
//
//    @PostMapping("/listPage")
//    public PageUtil<Dict> listPage(@RequestBody Page page) {
//        return dictService.listPage(page);
//    }
//
//    @RequestMapping(value = "/getDefaultValue", method = RequestMethod.GET)
//    public String getDefaultValue(@RequestParam("group") String group) {
//        return dictService.getDefaultValue(group);
//    }
//
//    @RequestMapping(value = "/getValue", method = RequestMethod.GET)
//    public String getValue(@RequestParam("group") String group, @RequestParam("code") String code) {
//        return dictService.getValue(group, code);
//    }
//
//}
