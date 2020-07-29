package com.fleet.consumer.controller.admin.msg;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.msg.Msg;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.msg.MsgService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 消息管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/msg")
public class MsgController extends BaseController<Msg> {

    @Reference
    private MsgService msgService;

    @Override
    public BaseService<Msg> baseService() {
        return msgService;
    }

    @Override
    @PostMapping("/insert")
    public R insert(@RequestBody Msg msg) {
        msg.setCreatorId(getUserId());
        msg.setCreateTime(new Date());
        if (!msgService.insert(msg)) {
            return R.error();
        }
        return R.ok();
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Long id) {
        Msg msg = new Msg();
        msg.setId(id);
        return get(msg);
    }

    @PostMapping("/toListPage")
    public PageUtil<Msg> toListPage(@RequestBody Page page) {
        page.put("to", getUserId());
        return msgService.toListPage(page);
    }
}
