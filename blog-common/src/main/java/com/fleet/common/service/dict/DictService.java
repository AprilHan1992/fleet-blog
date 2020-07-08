package com.fleet.common.service.dict;

import com.fleet.common.entity.dict.Dict;
import com.fleet.common.service.BaseService;

/**
 * @author April Han
 */
public interface DictService extends BaseService<Dict> {

    String getDefaultValue(String group);

    String getValue(String group, String code);
}
