package com.fleet.consumer.controller.admin.mail;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.mail.MailGroup;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.mail.MailGroupService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 邮箱组管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/mail/group")
public class MailGroupController extends BaseController<MailGroup> {

    @Reference
    private MailGroupService mailGroupService;

    @Override
    public BaseService<MailGroup> baseService() {
        return mailGroupService;
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Long id) {
        MailGroup mailGroup = new MailGroup();
        mailGroup.setId(id);
        return R.ok(mailGroupService.get(mailGroup));
    }
}
