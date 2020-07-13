package com.fleet.common.service.msg;

import com.fleet.common.entity.msg.Msg;
import com.fleet.common.service.BaseService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;

/**
 * @author April Han
 */
public interface MsgService extends BaseService<Msg> {

    PageUtil<Msg> toListPage(Page page);
}
