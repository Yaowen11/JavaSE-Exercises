package think.fifteen.genericinterface;

import java.util.*;

/**
 * @author zyw
 * @date 2020/8/22 16:36
 */
public class New {
    public static <K,V> Map<K,V> map() {
        return new HashMap<>();
    }
    public static <T> List<T> list() {
        return new ArrayList<>();
    }
    public static <T> Set<T> set() {
        return new HashSet<>();
    }
    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }
}
