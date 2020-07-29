package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.dict.Dict;
import com.fleet.common.entity.dict.Value;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictControllerTests extends BaseTests {

    @Test
    public void insert() {
        Dict dict = new Dict();
        dict.setGroup("test");
        dict.setRemark("测试组");
        List<Value> valueList = new ArrayList<>();
        Value v1 = new Value();
        v1.setCode("code1");
        v1.setValue("值1");
        v1.setRemark("值1");
        v1.setIsDefault(1);
        valueList.add(v1);

        Value v2 = new Value();
        v2.setCode("code2");
        v2.setValue("值2");
        v2.setRemark("值2");
        v2.setIsDefault(1);
        valueList.add(v2);

        dict.setValueList(valueList);
        super.post("/dict/insert", JSONObject.toJSONString(dict));
    }

    @Test
    public void delete() {
        Dict dict = new Dict();
        dict.setId(1L);
        super.post("/dict/delete", JSONObject.toJSONString(dict));
    }

    @Test
    public void deletes1() {
        super.get("/dict/deletes?ids=1&ids=2&ids=3");
        super.post("/dict/deletes?ids=1&ids=2&ids=3");
    }

    @Test
    public void deletes2() {
        Map<String, String[]> params = new HashMap<>();
        params.put("ids", new String[]{"1", "2", "3"});
        super.get("/dict/deletes", params);
        super.post("/dict/deletes", params);
    }

    @Test
    public void update() {
        Dict dict = new Dict();
        dict.setId(1L);
        dict.setGroup("test");
        dict.setRemark("测试组");
        List<Value> valueList = new ArrayList<>();
        Value v1 = new Value();
        v1.setCode("code1");
        v1.setValue("值1");
        v1.setRemark("值1");
        v1.setIsDefault(1);
        valueList.add(v1);

        Value v2 = new Value();
        v2.setCode("code2");
        v2.setValue("值2");
        v2.setRemark("值2");
        v2.setIsDefault(1);
        valueList.add(v2);

        dict.setValueList(valueList);
        super.post("/dict/update", JSONObject.toJSONString(dict));
    }

    @Test
    public void get1() {
        Dict dict = new Dict();
        dict.setId(1L);
        super.post("/dict/get", JSONObject.toJSONString(dict));
    }

    @Test
    public void get2() {
        super.get("/dict/get?id=1");
    }

    @Test
    public void list() {
        super.get("/dict/list");
    }

    @Test
    public void listPage() {
        Page page = new Page();
        super.post("/dict/listPage", JSONObject.toJSONString(page));
    }

    @Test
    public void getDefaultValue() {
        super.get("/dict/getDefaultValue?group=test");
    }

    @Test
    public void getValue() {
        super.get("/dict/getValue?group=test&code=code2");
    }
}
