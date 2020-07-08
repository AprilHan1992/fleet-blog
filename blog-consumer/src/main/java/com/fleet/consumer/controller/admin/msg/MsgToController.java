package com.fleet.consumer.controller.admin.sys.msgTo;

import com.fleet.common.entity.msg.MsgTo;
import com.fleet.common.json.R;
import com.fleet.common.service.msg.MsgToService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/msg/to")
public class MsgToController {

    @Reference
    private MsgToService msgToService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody MsgTo msgTo) {
        msgToService.insert(msgTo);
        return R.ok();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestBody MsgTo msgTo) {
        msgToService.delete(msgTo);
        return R.ok();
    }

    @RequestMapping(value = "/deletes", method = RequestMethod.POST)
    public R deletes(@RequestBody List<MsgTo> msgToList) {
        for (MsgTo msgTo : msgToList) {
            msgToService.delete(msgTo);
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody MsgTo msgTo) {
        msgToService.update(msgTo);
        return R.ok();
    }
}
