package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by daihua on 2015/11/18.
 */
public class PropsUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);
    private static volatile Properties props;

    private PropsUtil() {
    }

    /**
     * load the properties files
     * @param fileName
     * @return
     * @throws IOException
     */
    private static synchronized Properties loadProps(String fileName){
        Properties p = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(String.format("%s is not found", fileName));
            } else {
                p = new Properties();
                p.load(is);
            }
        }catch (IOException e){
            logger.error("props load faild",e);
        }finally {
            if(is!=null){
                try {
                    is.close();
                }catch (IOException e1){
                    logger.error(e1.getMessage(),e1);
                }
            }
        }
        return p;
    }

    public static Properties getProps(String fileName){
        if(props==null) {
            props = loadProps(fileName);
        }
        return props;
    }

    /**
     * get the value in the properties
     * @param key
     * @param props
     * @return
     */
    public static String getPropsValue(String key,Properties props){
        String result = props.getProperty(key);
        return result;
    }

    /**
     *
     * @param key
     * @param props
     * @param defaultVal
     * @return
     */
    public static String getPropsValue(String key,Properties props,String defaultVal){
        if(props.containsKey(key)){
            String result = getPropsValue(key,props);
            return result;
        }else{
            return defaultVal;
        }
    }

    /**
     * @param key
     * @param props
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T  getPropsValue(String key,Properties props,Class<T> clazz){
        if(props.containsKey(key)){
            return clazz.cast(getPropsValue(key,props));
        }else{
            return null;
        }
    }

    /**
     * @param key
     * @param props
     * @param defaultVal
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getPropsValue(String key,Properties props,Object defaultVal,Class<T> clazz){
        if(props.containsKey(key)){
            return clazz.cast(getPropsValue(key,props));
        }else{
            return clazz.cast(defaultVal);
        }
    }

}
