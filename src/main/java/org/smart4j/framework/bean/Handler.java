package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * Created by daihua on 2015/11/23.
 */
public class Handler {
    private Class<?> controllerClass; //controller 类

    private Method actionMethod; //action 方法

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass(){
        return controllerClass;
    }

    public Method getActionMethod(){
        return actionMethod;
    }
}
