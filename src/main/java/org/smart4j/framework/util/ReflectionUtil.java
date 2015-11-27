package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 * Created by daihua on 2015/11/20.
 */
public final class ReflectionUtil {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

    public static Object newInstance(Class<?> cls){
        Object instance ;
        try {
            instance = cls.newInstance();
        } catch (Exception e) {
            logger.error("new instance faild",e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    public static Object invokeMethod(Object object, Method method,Object... args){
        Object result;
        try {
            method.setAccessible(true);  // 设置可进入权限，使其可进行private方法调用
            result = method.invoke(object, args);
        } catch (Exception e) {
            logger.error("invoke method faild",e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void setField(Object object,Field field,Object value){
        try {
            field.setAccessible(true);
            field.set(object,value);
        } catch (Exception e) {
            logger.error("set field failure",e);
            throw new RuntimeException(e);
        }
    }
}
