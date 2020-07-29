package com.fleet.consumer.controller.admin.dict;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.dict.Value;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.dict.ValueService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典值管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/value")
public class ValueController extends BaseController<Value> {

    @Reference
    private ValueService valueService;

    @Override
    public BaseService<Value> baseService() {
        return valueService;
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Long id) {
        Value value = new Value();
        value.setId(id);
        return get(value);
    }
}
