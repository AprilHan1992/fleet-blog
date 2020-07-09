package com.fleet.consumer.controller.admin.dict;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.dict.Value;
import com.fleet.common.enums.IsDefault;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.dict.ValueService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

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

    @Override
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody Value value) {
        Value v = new Value();
        v.setDictId(value.getDictId());
        v.setCode(value.getCode());
        v = valueService.get(v);
        if (v != null) {
            return R.error("字典标签已存在");
        }
        if (value.getIsDefault().equals(IsDefault.YES)) {
            v = new Value();
            v.setDictId(value.getDictId());
            v.setIsDefault(IsDefault.YES);
            v = valueService.get(v);
            if (v != null) {
                v.setIsDefault(IsDefault.NO);
                valueService.update(v);
            }
        }
        if (!valueService.insert(value)) {
            return R.error();
        }
        return R.ok();
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody Value value) {
        if (StringUtils.isNotEmpty(value.getCode())) {
            Value v = new Value();
            v.setDictId(value.getDictId());
            v.setCode(value.getCode());
            v = valueService.get(v);
            if (v != null && !v.getId().equals(value.getId())) {
                return R.error("字典标签已存在");
            }
        }
        if (value.getIsDefault().equals(IsDefault.YES)) {
            Value v = new Value();
            v.setDictId(value.getDictId());
            v.setIsDefault(IsDefault.YES);
            v = valueService.get(v);
            if (v != null && !v.getId().equals(value.getId())) {
                v.setIsDefault(IsDefault.NO);
                valueService.update(v);
            }
        }
        if (!valueService.update(value)) {
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("id") Integer id) {
        Value value = new Value();
        value.setId(id);
        return get(value);
    }
}
