package com.fleet.provider.admin.config.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author April Han
 */
@Component("testTask1")
public class TestTask1 {

    private final static Logger logger = LoggerFactory.getLogger(TestTask1.class);

    public void run() {
        logger.debug("无参定时任务定时执行");
    }
}
