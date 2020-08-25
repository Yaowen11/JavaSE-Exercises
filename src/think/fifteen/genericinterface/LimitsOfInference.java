package think.fifteen.genericinterface;

import think.fourteen.Person;

import java.util.*;

/**
 * @author zyw
 * @date 2020/8/22 16:39
 */
public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> pets){
        pets.forEach((k, v)-> System.out.println(k.getClass().getSimpleName() + v.getClass().getSimpleName()));
    }
    public static void main(String[] args) {
        f(New.map());
        lost();
    }

    public static void lost() {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
    }
}
