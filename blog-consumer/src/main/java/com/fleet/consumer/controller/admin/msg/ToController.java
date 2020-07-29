package com.fleet.consumer.controller.admin.msg;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.msg.To;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.msg.ToService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息接收管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/to")
public class ToController extends BaseController<To> {

    @Reference
    private ToService toService;

    @Override
    public BaseService<To> baseService() {
        return toService;
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Long id) {
        To to = new To();
        to.setId(id);
        return get(to);
    }
}
