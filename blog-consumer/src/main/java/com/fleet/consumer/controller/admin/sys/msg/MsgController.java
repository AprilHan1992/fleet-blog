package com.fleet.consumer.controller.admin.sys.msg;

import com.fleet.common.entity.msg.Msg;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.msg.MsgService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Reference
    private MsgService msgService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody Msg msg) {
        msgService.insert(msg);
        return R.ok();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("msgId") Integer msgId) {
        Msg msg = new Msg();
        msg.setMsgId(msgId);
        msgService.delete(msg);
        return R.ok();
    }

    @RequestMapping(value = "/delete/batch", method = {RequestMethod.GET, RequestMethod.POST})
    public R deleteBatch(@RequestParam("msgIds") List<Integer> msgIds) {
        for (Integer msgId : msgIds) {
            Msg msg = new Msg();
            msg.setMsgId(msgId);
            msgService.delete(msg);
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody Msg msg) {
        msgService.update(msg);
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("msgId") Integer msgId) {
        Msg msg = new Msg();
        msg.setMsgId(msgId);
        return R.ok(msgService.get(msg));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(msgService.list(map));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<Msg> listPage(@RequestBody Page page) {
        return msgService.listPage(page);
    }

    @RequestMapping(value = "/user/listPage", method = RequestMethod.POST)
    public PageUtil<Msg> userMsgListPage(@RequestBody Page page) {
        return msgService.userMsgListPage(page);
    }
}
