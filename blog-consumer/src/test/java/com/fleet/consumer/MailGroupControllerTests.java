package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.mail.MailGroup;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MailGroupControllerTests extends BaseTests {

    @Test
    public void insert() {
        MailGroup mailGroup = new MailGroup();
        mailGroup.setName("资产邮箱组");
        mailGroup.setTos("fleet@fleet.com,admin@fleet.com");
        super.post("/mail/group/insert", JSONObject.toJSONString(mailGroup));
    }

    @Test
    public void delete() {
        MailGroup mailGroup = new MailGroup();
        mailGroup.setId(1);
        super.post("/mail/group/delete", JSONObject.toJSONString(mailGroup));
    }

    @Test
    public void deletes1() {
        super.get("/mail/group/deletes?ids=1&ids=2&ids=3");
        super.post("/mail/group/deletes?ids=1&ids=2&ids=3");
    }

    @Test
    public void deletes2() {
        Map<String, String[]> params = new HashMap<>();
        params.put("ids", new String[]{"1", "2", "3"});
        super.get("/mail/group/deletes", params);
        super.post("/mail/group/deletes", params);
    }

    @Test
    public void update() {
        MailGroup mailGroup = new MailGroup();
        mailGroup.setId(1);
        mailGroup.setName("项目部");
        super.post("/mail/group/update", JSONObject.toJSONString(mailGroup));
    }

    @Test
    public void get1() {
        MailGroup mailGroup = new MailGroup();
        mailGroup.setId(1);
        super.post("/mail/group/get", JSONObject.toJSONString(mailGroup));
    }

    @Test
    public void get2() {
        super.get("/mail/group/get?id=3");
    }

    @Test
    public void list() {
        super.get("/mail/group/list");
    }

    @Test
    public void listPage() {
        Page page = new Page();
        super.post("/mail/group/listPage", JSONObject.toJSONString(page));
    }
}
