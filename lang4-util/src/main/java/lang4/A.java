/**
 * Copyright (C) 2015 haixiaoyao, Inc. All Rights Reserved.
 */
package lang4;

import org.apache.commons.lang3.ArrayUtils;

/**
 * array tool function
 * 
 * @author xiezhenzong
 *
 */
public final class A {

    /**
     * true if array is null or empty, false otherwise
     * 
     */
    public static <T> boolean isEmpty(T[] array) {
        return ArrayUtils.isEmpty(array);
    }

    /**
     * true if array contain at least one value, false otherwise
     */
    public static <T> boolean notEmpty(T[] array) {
        return ArrayUtils.isNotEmpty(array);
    }

    /**
     * handle array item one by one.
     * 
     * if array is null or empty, then return false.
     * 
     * if loop exit when iterating, then return false.
     * 
     * after iterating, return true.
     * 
     */
    public static <T> boolean forEach(T[] array, Action action) {
        if (A.isEmpty(array)) {
            return false;
        }
        for (int index = 0, n = array.length; index < n; index++) {
            T target = array[index];
            if (!action.action(target, index)) {
                return false;
            }
        }
        return true;
    }

    /**
     * handle array item one by one except null item
     */
    public static <T> boolean forEachSkipNull(T[] array, final Action action) {
        return forEach(array, new Action() {

            @Override
            public boolean action(Object value, Object...args) {
                return value != null ? action.action(value, args) : true;
            }
        });
    }

}
