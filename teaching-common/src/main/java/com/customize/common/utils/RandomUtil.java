package com.customize.common.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class RandomUtil {

    // 编号格式化
    private final static String no_format = "yyMMddHHmmssSSS";

    // 编号锁
    private final static byte[] noLock = new byte[]{};

    public static String randomNo() {
        int seq_no = cn.hutool.core.util.RandomUtil.randomInt(0, 9);
        synchronized (noLock) {
            Date now = new Date();
            try {
                // 线程沉睡1毫秒，避免时间重复
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return DateUtil.format(now, no_format).concat(String.valueOf(seq_no));
        }
    }
}
