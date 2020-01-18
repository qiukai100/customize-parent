package com.customize.feign.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonResultUtil {

    public static JSONObject beanToJson(Object obj) {
        return JSONObject.parseObject(JSONObject.toJSONString(obj));
    }

    public static <T> T jsonToBean(JSONObject jsonObject, Class<T> clazz) {
        return JSONObject.parseObject(jsonObject.toJSONString(), clazz);
    }
}
