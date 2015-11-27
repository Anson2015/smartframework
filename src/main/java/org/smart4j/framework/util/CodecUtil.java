package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by daihua on 2015/11/24.
 */
public final class CodecUtil {
    private static Logger logger = LoggerFactory.getLogger(CodecUtil.class);

    public static String encodeURL(String source,String enc){
        String target;
        try{
            target = URLEncoder.encode(source,enc);
        }catch(Exception e){
            logger.error("encode url failed",e);
            throw new RuntimeException(e);
        }
        return target;
    }

    public static String decodeURL(String source,String enc){
        String target ;
        try{
            target = URLDecoder.decode(source,enc);
        }catch (Exception e){
            logger.error("decode url failed",e);
            throw new RuntimeException(e);
        }
        return target;
    }
}
