package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by daihua on 2015/11/24.
 */
public final class StreamUtil {
    private static final Logger logger = LoggerFactory.getLogger(StreamUtil.class);

    public static String getString (InputStream inputStream){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null){
                sb.append(line);
            }
        }catch (IOException e){
            logger.error("get string failed",e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
