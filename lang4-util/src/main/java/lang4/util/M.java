package lang4.util;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;

/**
 * map util
 * 
 * @author xiezhenzong
 *
 */
public class M {

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return MapUtils.isEmpty(map);
    }

    public static <K, V> boolean notEmpty(Map<K, V> map) {
        return MapUtils.isNotEmpty(map);
    }

    public static <K, V> boolean forEach(Map<K, V> map, Action<V> action) {
        if (isEmpty(map))
            return false;
        for (Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (!action.action(value, key, map)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean forEachSkipNull(Map<K, V> map, final Action<V> action) {
        return forEach(map, new Action<V>() {
            @Override
            public boolean action(V value, Object...args) {
                return value != null ? action.action(value, args) : true;
            }
        });
    }

}
