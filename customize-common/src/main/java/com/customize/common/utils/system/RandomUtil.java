package com.customize.common.utils.system;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class RandomUtil {

    // 编号格式化
    private final static String no_format = "yyMMddHHmmssSSS";

    // 编号锁
    private final static byte[] noLock = new byte[]{};

    // 上一次的时间
    private static long currTime = 0;

    public static String randomNo() {
        int seq_no = cn.hutool.core.util.RandomUtil.randomInt(0, 9);
        synchronized (noLock) {
            Date now = new Date();
            if (currTime != 0 && currTime == now.getTime()) {
                try {
                    // 线程沉睡1毫秒，避免时间重复
                    Thread.sleep(1);
                    now = new Date();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currTime = now.getTime();
            return DateUtil.format(now, no_format).concat(String.valueOf(seq_no));
        }
    }
}
