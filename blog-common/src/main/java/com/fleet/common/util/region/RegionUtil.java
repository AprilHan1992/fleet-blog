package com.fleet.common.util.region;

import com.fleet.common.util.region.entity.Region;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 地区信息工具类(需要在 resources下配置 ip2region/ip2region.db 文件)
 */
public class RegionUtil {

    /**
     * 根据ip获取地区信息
     */
    public static Region getRegion(String ip) {
        DbSearcher dbSearcher = null;
        try {
            File file = new ClassPathResource("ip2region/ip2region.db").getFile();
            dbSearcher = new DbSearcher(new DbConfig(), file.getPath());
            Method method = dbSearcher.getClass().getMethod("btreeSearch", String.class);
            DataBlock dataBlock = (DataBlock) method.invoke(dbSearcher, ip);
            String[] regions = dataBlock.getRegion().trim().split("\\|");
            Region region = new Region();
            if (regions[0].equals("内网IP") || regions[2].equals("内网IP") || regions[3].equals("内网IP")) {
                region.setCountry("未知");
                region.setProvince("未知");
                region.setCity("未知");
                return region;
            }
            region.setCountry(regions[0]);
            region.setProvince(regions[2]);
            region.setCity(regions[3]);
            return region;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dbSearcher != null) {
                try {
                    dbSearcher.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
