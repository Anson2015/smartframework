package org.smart4j.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by daihua on 2015/11/23.
 */
public class ArrayUtil {
    public static Boolean isNotEmpty(Object[] object){
        return ArrayUtils.isNotEmpty(object);
    }

    public static Boolean isEmpty(Object[] object){
        return ArrayUtils.isEmpty(object);
    }
}
