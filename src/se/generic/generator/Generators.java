package se.generic.generator;

import se.generic.Fibonacci;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhangyaowen
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }
    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<>(), new CoffeeGenerator(), 5);
        for (Coffee coffee: coffees) {
            System.out.println(coffee);
        }
        Collection<Long> fbs = fill(new ArrayList<>(), new Fibonacci(), 12);
        for (long i: fbs) {
            System.out.print(i + ", ");
        }
    }
}
