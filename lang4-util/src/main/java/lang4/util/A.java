package lang4.util;

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
    public static <T> boolean forEach(T[] array, Action<T> action) {
        if (A.isEmpty(array)) {
            return false;
        }
        for (int index = 0, n = array.length; index < n; index++) {
            T target = array[index];
            if (!action.action(target, index, array)) {
                return false;
            }
        }
        return true;
    }

    /**
     * handle array item one by one except null item
     */
    public static <T> boolean forEachSkipNull(T[] array, final Action<T> action) {
        return forEach(array, new Action<T>() {
            @Override
            public boolean action(T value, Object...args) {
                return value != null ? action.action(value, args) : true;
            }
        });
    }

}
