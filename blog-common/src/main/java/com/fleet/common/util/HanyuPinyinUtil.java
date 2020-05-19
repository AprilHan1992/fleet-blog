package com.fleet.common.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 汉语拼音
 */
public class HanyuPinyinUtil {

    /**
     * 汉语转成拼音首字母
     */
    public static String hanyu2InitialPinyin(String str) {
        String separate = "-";
        return hanyu2InitialPinyin(str, separate).replace(separate, "");
    }

    /**
     * 汉语转成拼音首字母
     */
    public static String hanyu2InitialPinyin(String str, String separate) {
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        // 拼音大写字母
        outputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        // 无声调
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        try {
            String pinyin = PinyinHelper.toHanYuPinyinString(str, outputFormat, separate, true);
            if (StringUtils.isNotEmpty(pinyin)) {
                List<String> list = new ArrayList<>();
                String[] strings = pinyin.split(separate);
                for (String s : strings) {
                    list.add(s.trim().substring(0, 1).toUpperCase());
                }
                return StringUtils.join(list, separate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 汉语转成拼音
     */
    public static String hanyu2Pinyin(String str) {
        String separate = "-";
        return hanyu2Pinyin(str, separate).replace(separate, "");
    }

    /**
     * 汉语转成拼音
     */
    public static String hanyu2Pinyin(String str, String separate) {
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        // 拼音大写字母
        outputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        // 无声调
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        try {
            return PinyinHelper.toHanYuPinyinString(str, outputFormat, separate, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
