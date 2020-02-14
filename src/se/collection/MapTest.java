package se.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyaowen
 */
public class MapTest {

    <K, V> void mapDump(Map<K, V> map) {
        System.out.println(map);
    }

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        Map<String, String> staff = new HashMap<>(4);
        staff.put("hubei", "wihan");
        staff.put("hunan", "changsha");
        staff.put("zhejiang", "hangzhou");
        staff.put("china", "beijing");
        mapTest.mapDump(staff);
        staff.remove("hubei");
        staff.forEach((k, v)->System.out.println("key=" + k + ", value=" + v));
    }
}
