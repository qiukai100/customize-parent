package com.customize.common.utils;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdcardUtil;
import com.customize.common.annotations.CustVerify;
import com.customize.common.constants.RegexEnum;
import com.customize.common.constants.VerifyTypeEnum;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyUtil {

    /**
     * 验证通过时的消息
     */
    private final static String success_msg = "verify pass";

    private static String verifyPass() {
        return success_msg;
    }

    private static String verifyFail(String msg) {
        return msg;
    }

    /**
     * 检查验证是否通过
     *
     * @param msg 验证后的返回码
     *
     * @return true为验证通过，false则不通过
     */
    public static boolean vailIsPass(String msg) {
        return msg.equals(success_msg);
    }

    public static String verifyEntity(Object bean) {
        Class<?> clazz = bean.getClass();
        if (!BeanUtil.isBean(clazz)) {
            return verifyFail("The data must be a bean");
        }
        // 获取对象中所有的field，包括基类
        List<Field> fieldList = new ArrayList<>();
        boolean loop = true;
        while (loop){
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
            loop = clazz != null;
        }

        try {
            // 开始验证
            for (Field field : fieldList) {
                // 赋予读取私有属性的权限
                field.setAccessible(true);
                CustVerify custVerify = field.getAnnotation(CustVerify.class);
                if (custVerify == null)
                    continue;
                Object val = field.get(bean);
                String key = field.getName();
                if (custVerify.verifyType().equals(VerifyTypeEnum.USUALLY)) {
                    if (custVerify.notEmpty()) {
                        String msg = key.concat(" Failed verification not empty");
                        if (!notEmpty(val))
                            return verifyFail(msg);
                    }
                    if (!custVerify.regex().equals(RegexEnum.NONE)) {
                        // 存在自定义正则，参数不为空时，进行正则校验
                        if (val != null) {
                            String valStr = String.valueOf(val);
                            if (!match(custVerify.regex(), valStr))
                                return verifyFail(custVerify.msg());
                        }
                    }
                    if (custVerify.minSize() != 0) {
                        if (val != null) {
                            String msg = key.concat(" Cannot be less than ").concat(String.valueOf(custVerify.minSize())).concat(" digits in length");
                            if (!minSize(val, custVerify.minSize()))
                                return verifyFail(msg);
                        }
                    }
                    if (custVerify.maxSize() != 0) {
                        if (val != null) {
                            String msg = key.concat(" Cannot be greater than ").concat(String.valueOf(custVerify.maxSize())).concat(" digits in length");
                            if (!maxSize(val, custVerify.maxSize()))
                                return verifyFail(msg);
                        }
                    }
                } else {
                    // 特殊情况验证
                    if (custVerify.notEmpty()) {
                        String msg = key.concat(" Failed verification not empty");
                        if (!notEmpty(val))
                            return verifyFail(msg);
                    }
                    if (val != null) {
                        String valStr = String.valueOf(val);
                        if (!custVerify.regex().equals(RegexEnum.NONE)) {
                            // 存在自定义正则，参数不为空时，替代默认的邮箱正则
                            if (!match(custVerify.regex(), valStr))
                                return verifyFail(custVerify.msg());
                        } else {
                            switch (custVerify.verifyType()) {
                                case EMAIL:
                                    if (!Validator.isEmail(valStr)) {
                                        return verifyFail(custVerify.msg());
                                    }
                                    break;
                                case MOBILE_PHONE:
                                    if (!Validator.isMobile(valStr)) {
                                        return verifyFail(custVerify.msg());
                                    }
                                    break;
                                case IDENTITY_CARD:
                                    if (!IdcardUtil.isValidCard(valStr)) {
                                        return verifyFail(custVerify.msg());
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return verifyFail("Unexpected problems when validating data");
        }
        return verifyPass();
    }

    private static boolean notEmpty(Object val) {
        if (val == null)
            return false;
        if (val instanceof String) {
            String valStr = String.valueOf(val);
            if (valStr.trim().equals(""))
                return false;
        }
        return true;
    }

    private static boolean minSize(Object val, int size) {
        String valStr = String.valueOf(val);
        return valStr.trim().length() >= size;
    }

    private static boolean maxSize(Object val, int size) {
        String valStr = String.valueOf(val);
        return valStr.trim().length() <= size;
    }

    private static boolean match(RegexEnum regexEnum, String str) {
        Pattern pattern = Pattern.compile(regexEnum.getRegex());
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
