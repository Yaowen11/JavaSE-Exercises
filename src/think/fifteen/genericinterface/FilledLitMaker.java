package think.fifteen.genericinterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyw
 * @date 2020/8/22 20:53
 */
public class FilledLitMaker {
    <T> List<T> create(T t, int n) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(t);
        }
        return list;
    }
    public static void main(String[] args) {
        FilledLitMaker filledLitMaker = new FilledLitMaker();
        List<String> list = filledLitMaker.create("Hello", 4);
        System.out.println(list);
    }
}
