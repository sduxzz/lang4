/**
 * Copyright (C) 2015 haixiaoyao, Inc. All Rights Reserved.
 */
package lang4.util;

/**
 * action when loop on string, array, collection, map
 * 
 * @author xiezhenzong
 *
 */
public interface Action<T> {

    /**
     * 当在array, collection, map 上循环时，调用action，对每一项进行处理，
     * 
     * value是需要进行处理的元素
     * 
     * <ol>
     * <li>在array，list上循环时，args第一项是index，第二项是要array, list
     * <li>在set上循环时，args第一项是set
     * <li>在map上循环时，args第一项是key，第二项时map
     * </ol>
     * 
     * 如果不需要继续循环则返回false;
     * 
     * 
     */
    boolean action(T value, Object...args);

}
