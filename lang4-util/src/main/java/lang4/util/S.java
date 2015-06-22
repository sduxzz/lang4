/**
 * Copyright (C) 2015 haixiaoyao, Inc. All Rights Reserved.
 */
package lang4.util;

import org.apache.commons.lang3.StringUtils;

/**
 * String tool function
 * 
 * @author xiezhenzong
 *
 */
public final class S {

    /**
     * true if string is null or zero length, false otherwise
     */
    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    /**
     * true if string is not null or zero length, false otherwise
     */
    public static boolean notEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }
}
