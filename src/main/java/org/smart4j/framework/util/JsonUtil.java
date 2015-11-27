package org.smart4j.framework.util;

import com.alibaba.fastjson.JSON;

/**
 * Created by daihua on 2015/11/24.
 */
public final class JsonUtil {

    public static String toJson(Object object){
        String result = JSON.toJSONString(object);
        return result;
    }

    public static <T> T fromJson(String json, Class<T> type){
        T pojo = JSON.parseObject(json,type);
        return pojo;
    }
}
