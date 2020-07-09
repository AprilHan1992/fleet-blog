package com.fleet.consumer;

import com.fleet.common.entity.dict.Dict;
import com.fleet.common.service.dict.DictService;
import com.fleet.common.util.VerifyUtil;
import com.fleet.common.util.region.RegionUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;

public class ConsumerApplicationTests extends BaseTests {

    @Reference
    private DictService dictService;

    @Test
    public void insert() {
        Dict dict = new Dict();
        dict.setGroup("测试1");
        dict.setRemark("测试");
        dictService.insert(dict);
    }

    @Test
    public void getCity() {
        RegionUtil.getRegion("172.30.18.97");
//        RegionUtil.getRegion("123.125.71.38");
    }

    @Test
    public void Verify() {
//        System.out.println(VerifyUtil.isEmail("fleetsoft@qq.com"));
//        System.out.println(VerifyUtil.isEmail("fleetsoft@fleetsoft.com.cn"));
//        System.out.println(VerifyUtil.isEmail("fleet.soft@fleetsoft.com.cn"));
//        System.out.println(VerifyUtil.isEmail("fleet_soft@fleetsoft.com.cn"));
        System.out.println(VerifyUtil.isPhone("1975555555s"));
        System.out.println(VerifyUtil.isPhone("17460555555"));
    }
}
