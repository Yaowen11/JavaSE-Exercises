package think.thirteen;

import think.Constant;
import think.eleven.Fruit;
import think.eleven.FruitFunc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyw
 * @date 2020/6/7 19:58
 */
public class ArrayListDisplay {
    public static void dump() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < Constant.TEN; i++) {
            fruits.add(FruitFunc.fruitFactory.next());
        }
        System.out.println(fruits);
    }

    static class InfiniteRecursion {
        @Override public String toString() {
            return " InfiniteRecursion address: " + super.toString() + "\n";
        }
        public void dump() {
            List<InfiniteRecursion> fruitList = new ArrayList<>();
            for (int i = 0; i < Constant.TEN; i++) {
                fruitList.add(new InfiniteRecursion());
            }
            System.out.println(fruitList);
        }
    }

    public static void main(String[] args) {
        dump();
        InfiniteRecursion infiniteRecursion = new InfiniteRecursion();
        infiniteRecursion.dump();
        String zh = "Java编程思想,🐍🐂媱";
        System.out.println(zh.length());
        System.out.println(zh.charAt(12));
        System.out.println(zh.chars());
        System.out.println(Character.toLowerCase(74));
        System.out.println();
        zh.chars().forEach(System.out::println);
    }
}
