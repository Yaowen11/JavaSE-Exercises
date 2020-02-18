package se.generic.generation;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Random;

/**
 * @author zhangyaowen
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class<?>[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};

    private static Random rand = new Random(47);

    private Integer size;

    public CoffeeGenerator() {}

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    /**
     * generate T
     *
     * @return T
     */
    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    class CoffeeIterator implements Iterator<Coffee> {
        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public Coffee next() {
            size--;
            return CoffeeGenerator.this.next();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator();
        int loop = 5;
        for (int i = 0; i < loop; i++) {
            System.out.println(coffeeGenerator.next());
        }
        for (Coffee c: new CoffeeGenerator(loop)) {
            System.out.println(c);
        }
    }
}
