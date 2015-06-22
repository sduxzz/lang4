/**
 * Copyright (C) 2015 haixiaoyao, Inc. All Rights Reserved.
 */
package lang4.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

/**
 * collection util
 * 
 * @author xiezhenzong
 *
 */
public class C {

    public static <T> boolean isEmpty(Collection<T> coll) {
        return CollectionUtils.isEmpty(coll);
    }

    public static <T> boolean notEmpty(Collection<T> coll) {
        return CollectionUtils.isNotEmpty(coll);
    }

    public static <T> boolean forEach(Collection<T> coll, Action<T> action) {
        if (isEmpty(coll))
            return false;
        int index = 0;
        for (T t : coll) {
            if (!action.action(t, index++, coll)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean forEachSkipNull(Collection<T> coll, final Action<T> action) {
        return forEach(coll, new Action<T>() {
            @Override
            public boolean action(T value, Object...args) {
                return value != null ? action.action(value, args) : true;
            }
        });
    }

    public static <T> Set<T> newSet(T...obj) {
        if (A.isEmpty(obj))
            return new HashSet<T>(0);

        final HashSet<T> set = new HashSet<T>();
        A.forEachSkipNull(obj, new Action<T>() {
            @Override
            public boolean action(T value, Object...args) {
                set.add(value);
                return true;
            }
        });
        return set;
    }

    public static <T> Set<T> newSetAllowNull(T...obj) {
        if (A.isEmpty(obj))
            return new HashSet<T>(0);

        final HashSet<T> set = new HashSet<T>();
        A.forEach(obj, new Action<T>() {
            @Override
            public boolean action(T value, Object...args) {
                set.add(value);
                return true;
            }
        });
        return set;
    }

}
