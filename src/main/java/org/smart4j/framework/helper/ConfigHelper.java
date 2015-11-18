package org.smart4j.framework.helper;

import org.smart4j.framework.ConfigConstant;
import org.smart4j.framework.util.PropsUtil;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by daihua on 2015/11/18.
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.getProps(ConfigConstant.CONFIG_FILE);


    /**
     * 获取 JDBC 驱动
     */
    public static String getJdbcDriver() {
        return PropsUtil.getPropsValue(ConfigConstant.JDBC_DRIVER,CONFIG_PROPS);
    }

    /**
     * 获取 JDBC URL
     */
    public static String getJdbcUrl() {
        return PropsUtil.getPropsValue(ConfigConstant.JDBC_URL,CONFIG_PROPS);
    }

    /**
     * 获取 JDBC 用户名
     */
    public static String getJdbcUsername() {
        return PropsUtil.getPropsValue(ConfigConstant.JDBC_USERNAME, CONFIG_PROPS);
    }

    /**
     * 获取 JDBC 密码
     */
    public static String getJdbcPassword() {
        return PropsUtil.getPropsValue(ConfigConstant.JDBC_PASSWORD, CONFIG_PROPS);
    }

    /**
     * 获取应用基础包名
     */
    public static String getAppBasePackage() {
        return PropsUtil.getPropsValue(ConfigConstant.APP_BASE_PACKAGE,CONFIG_PROPS);
    }

    /**
     * 获取应用 JSP 路径
     */
    public static String getAppJspPath() {
        return PropsUtil.getPropsValue(ConfigConstant.APP_JSP_PATH,CONFIG_PROPS,"/WEB-INF/view/");
    }

    /**
     * 获取应用静态资源路径
     */
    public static String getAppAssetPath() {
        return PropsUtil.getPropsValue(ConfigConstant.APP_ASSET_PATH, CONFIG_PROPS,  "/asset/");
    }
}
