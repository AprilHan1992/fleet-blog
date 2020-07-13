package com.fleet.consumer.controller.admin.log;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.log.Log;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.log.LogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/log")
public class LogController extends BaseController<Log> {

    @Reference
    private LogService logService;

    @Override
    public BaseService<Log> baseService() {
        return logService;
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Long id) {
        Log log = new Log();
        log.setId(id);
        return get(log);
    }
}
