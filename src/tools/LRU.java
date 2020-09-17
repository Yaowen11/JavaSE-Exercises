package tools;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        LinkedHashMap<String, String> accessOrderMap = new LinkedHashMap<>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 3;
            }
        };
        accessOrderMap.put("Project1", "Valhalla");
        accessOrderMap.put("Project2", "Panama");
        accessOrderMap.put("Project3", "Loom");
        accessOrderMap.forEach((k, v)->{
            System.out.println(k + ":" + v);
        });
        accessOrderMap.get("Project2");
        accessOrderMap.get("Project2");
        accessOrderMap.get("Project3");
        System.out.println("Iterate over should be not affected");
        accessOrderMap.forEach((k, v)-> {
            System.out.println(k + ":" + v);
        });
        accessOrderMap.put("Project4", "Mission Control");
        System.out.println("Oldest entry should be removed");
        accessOrderMap.forEach((k, v)-> {
            System.out.println(k + ":" + v);
        });
    }
}
