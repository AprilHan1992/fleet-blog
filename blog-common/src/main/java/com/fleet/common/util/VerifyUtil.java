package com.fleet.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * 信息验证工具类
 */
public class VerifyUtil {

    public static final String EMAIL_REGEX = "^[\\da-z]+([\\-._]?[\\da-z]+)*@[\\da-z]+([\\-.]?[\\da-z]+)*(\\.[a-z]{2,})+$";
    /**
     * 中国移动
     * 13[4-9],14[7-8],15[0-2,7-9],165,170[3,5,6],17[2,8],18[2-4,7-8],19[5,7-8]
     */
    public static final String CM_PHONE_REGEX = "^((13[4-9])|(14[7-8])|(15[0-2,7-9])|(165)|(17[2,8])|(18[2-4,7-8])|(19[5,7-8])|(170[3,5,6]))[\\d]+$";
    /**
     * 中国联通
     * 13[0-2],14[5-6],15[5-6],16[6-7],170[4,7-9],17[1,5-6],18[5-6],196
     */
    public static final String CU_PHONE_REGEX = "^((13[0-2])|(14[5-6])|(15[5-6])|(16[6-7])|(17[1,5-6])|(18[5-6])|(196)|(170[4,7-9]))[\\d]+$";
    /**
     * 中国电信
     * 133,149,153,162,170[0-2],17[3,7],174[0-5],18[0-1,189],19[0,1,3,9]
     */
    public static final String CT_PHONE_REGEX = "^((133)|(149)|(153)|(162)|(17[3,7])|(18[0-1,9])|(19[0-1,3,9])(170[0-2])|(174[0-5]))[\\d]+$";
    /**
     * 中国广电
     * 192
     */
    public static final String CBN_PHONE_REGEX = "^(192)[\\d]+$";

    /**
     * 验证是否为邮箱
     */
    public static boolean isEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    /**
     * 验证是否为手机号（针对国内）
     */
    public static boolean isPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return false;
        }
        if (phone.length() != 11) {
            return false;
        }
        boolean cm = Pattern.compile(CM_PHONE_REGEX).matcher(phone).matches();
        boolean cu = Pattern.compile(CU_PHONE_REGEX).matcher(phone).matches();
        boolean ct = Pattern.compile(CT_PHONE_REGEX).matcher(phone).matches();
        boolean cbn = Pattern.compile(CBN_PHONE_REGEX).matcher(phone).matches();
        return cm || cu || ct || cbn;
    }
}
