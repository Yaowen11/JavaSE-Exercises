package se.generic.generator;

import se.generic.generation.Generator;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author zhangyaowen
 */
public class GeneratorsTest {

    public static int size = 10;

    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.print(type.getSimpleName() + ": ");
            try {
                Generator<?> g = (Generator<?>) type.getDeclaredConstructor().newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.print(g.next() + " ");
                }
                System.out.println();
;            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void generateData() {
        Integer[] a = {9, 8, 7, 6};
        System.out.println(Arrays.toString(a));
        a = Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));
        Integer[] b = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        System.out.println(Arrays.toString(b));
    }

    public static void main(String[] args) {
        test(RandomGenerator.class);
        test(CountingGenerator.class);
        generateData();
    }

}
