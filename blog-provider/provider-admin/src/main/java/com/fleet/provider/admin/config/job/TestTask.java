package com.fleet.provider.admin.config.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author April Han
 */
@Component("testTask")
public class TestTask {

    private final static Logger logger = LoggerFactory.getLogger(TestTask.class);

    public void run(String params) {
        logger.debug("有参定时任务定时执行，参数为：{}", params);
    }
}
