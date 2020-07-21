package com.fleet.common.service.dict;

import com.fleet.common.entity.dict.Value;
import com.fleet.common.service.BaseService;

import java.util.List;

/**
 * @author April Han
 */
public interface ValueService extends BaseService<Value> {

    List<String> codeList(Integer dictId);
}
