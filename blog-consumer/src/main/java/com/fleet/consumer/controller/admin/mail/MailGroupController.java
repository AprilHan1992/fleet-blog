package com.fleet.consumer.controller.admin.mail;

import com.fleet.common.entity.mail.MailGroup;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.mail.MailGroupService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mail/group")
public class MailGroupController {

    @Reference
    private MailGroupService mailGroupService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody MailGroup mailGroup) {
        mailGroupService.insert(mailGroup);
        return R.ok();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("mailGroupId") Integer mailGroupId) {
        MailGroup mailGroup = new MailGroup();
        mailGroup.setMailGroupId(mailGroupId);
        mailGroupService.delete(mailGroup);
        return R.ok();
    }

    @RequestMapping(value = "/deletes", method = {RequestMethod.GET, RequestMethod.POST})
    public R deletes(@RequestParam("mailGroupIds") List<Integer> mailGroupIds) {
        for (Integer mailGroupId : mailGroupIds) {
            MailGroup mailGroup = new MailGroup();
            mailGroup.setMailGroupId(mailGroupId);
            mailGroupService.delete(mailGroup);
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody MailGroup mailGroup) {
        mailGroupService.update(mailGroup);
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("mailGroupId") Integer mailGroupId) {
        MailGroup mailGroup = new MailGroup();
        mailGroup.setMailGroupId(mailGroupId);
        return R.ok(mailGroupService.get(mailGroup));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(mailGroupService.list(map));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<MailGroup> listPage(@RequestBody Page page) {
        return mailGroupService.listPage(page);
    }
}
