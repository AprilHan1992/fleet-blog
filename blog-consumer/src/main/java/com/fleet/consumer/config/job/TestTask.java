package com.fleet.consumer.config.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author April Han
 */
@Component("testTask")
public class TestTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void run(String params) {
        logger.debug("TestTask定时任务正在执行run，参数为：{}", params);
    }

    public void run1(String params) {
        logger.debug("TestTask定时任务正在执行run1，参数为：{}", params);
    }
}
