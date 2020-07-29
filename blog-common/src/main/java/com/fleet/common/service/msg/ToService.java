package com.fleet.common.service.msg;

import com.fleet.common.entity.msg.To;
import com.fleet.common.service.BaseService;

import java.util.List;

/**
 * @author April Han
 */
public interface ToService extends BaseService<To> {

    List<Integer> toIdList(Long msgId);
}
