package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.dict.Dict;
import org.junit.Test;

public class DeptControllerTests extends BaseTests {

    @Test
    public void insert() {
        Dict dict = new Dict();
        dict.setDictGroup("测试1");
        dict.setDictRemark("测试");
        super.post("/dict/insert", JSONObject.toJSONString(dict));
    }

}
