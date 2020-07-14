package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class QuartzJobControllerTests extends BaseTests {

    @Test
    public void insert() {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setJobName("有参定时任务");
        quartzJob.setBeanName("testTask");
        quartzJob.setMethodName("run");
        quartzJob.setParam("参数");
        quartzJob.setCronExpression("*/20 * * * * ?");
        quartzJob.setEnabled(1);
        quartzJob.setRemark("有参定时任务");
        super.post("/quartz/job/insert", JSONObject.toJSONString(quartzJob));

        quartzJob = new QuartzJob();
        quartzJob.setJobName("无参定时任务");
        quartzJob.setBeanName("testTask");
        quartzJob.setMethodName("run");
        quartzJob.setCronExpression("*/20 * * * * ?");
        quartzJob.setEnabled(1);
        quartzJob.setRemark("无参定时任务");
        super.post("/quartz/job/insert", JSONObject.toJSONString(quartzJob));
    }

    @Test
    public void delete() {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setId(1);
        super.post("/quartz/job/delete", JSONObject.toJSONString(quartzJob));
    }

    @Test
    public void deletes1() {
        super.get("/quartz/job/deletes?ids=1&ids=2&ids=3");
        super.post("/quartz/job/deletes?ids=1&ids=2&ids=3");
    }

    @Test
    public void deletes2() {
        Map<String, String[]> params = new HashMap<>();
        params.put("ids", new String[]{"1", "2", "3"});
        super.get("/quartz/job/deletes", params);
        super.post("/quartz/job/deletes", params);
    }

    @Test
    public void update() {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setId(1);
        quartzJob.setJobName("测试");
        quartzJob.setBeanName("testTask");
        quartzJob.setMethodName("run");
        quartzJob.setParam("test");
        quartzJob.setCronExpression("*/20 * * * * ?");
        quartzJob.setEnabled(1);
        super.post("/quartz/job/update", JSONObject.toJSONString(quartzJob));
    }

    @Test
    public void get1() {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setId(1);
        super.post("/quartz/job/get", JSONObject.toJSONString(quartzJob));
    }

    @Test
    public void get2() {
        super.get("/quartz/job/get?id=3");
    }

    @Test
    public void list() {
        super.get("/quartz/job/list");
    }

    @Test
    public void listPage() {
        Page page = new Page();
        super.post("/quartz/job/listPage", JSONObject.toJSONString(page));
    }
}
