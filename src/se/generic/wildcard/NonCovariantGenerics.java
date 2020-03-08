package se.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author z
 */
public class NonCovariantGenerics {

    public static void main(String[] args) {
        NonCovariantGenerics nonCovariantGenerics = new NonCovariantGenerics();
        List<? super Fruit> list = nonCovariantGenerics.genericAdd();
        for (Object fruit : list) {
            System.out.println(fruit.getClass().getSimpleName());
        }
    }

    /**
     * 使用 super 添加
     * @return list
     */
    public List<? super Fruit> genericAdd() {
        // 使用通配符向上转型
        List<? super Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit());
        fruits.add(new Apple());
        fruits.add(new Jonathan());
        System.out.println(fruits);
        return fruits;
    }

    public void genericGet(List<? extends Fruit> list) {
        for (Fruit fruit : list) {
            System.out.println(fruit.getClass().getSimpleName());
        }
    }

    public <T extends Fruit> void add(T f) {

    }

    public static class Pair<T> {
        T t;
        public void dump() {
            System.out.println(t.getClass());
        }
    }

    public void minBonus(Pair<? super Jonathan> pair) {

    }

    public void maxBonus(Pair<? extends Fruit> pair) {

    }
}