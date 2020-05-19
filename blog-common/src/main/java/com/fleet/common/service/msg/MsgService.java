package com.fleet.common.service.msg;

import com.fleet.common.entity.msg.Msg;
import com.fleet.common.service.BaseService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;

public interface MsgService extends BaseService<Msg> {

    PageUtil<Msg> userMsgListPage(Page page);
}
