package think.eleven;

import think.Constant;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author zyw
 * @date 2020/5/28 21:07
 */
public class ListFeatures {
    public static void listDump() {
        Random random = new Random(Constant.FortySeven);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < Constant.TEN; i++) {
            list.add(random.nextInt());
        }
        System.out.println(list);
        List<Integer> sublist = list.subList(0, 5);
        System.out.println(sublist);
        sublist.set(1, 23);
        list.remove(7);
        sublist.remove(2);
        System.out.println(list);
        System.out.println(sublist);
    }
    public static void main(String[] args) {
        listDump();
    }
}
