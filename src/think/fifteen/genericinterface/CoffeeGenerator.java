package think.fifteen.genericinterface;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author zyw
 * @date 2020/6/22 20:56
 */
public class CoffeeGenerator implements Generator<Coffee> {
    private final Class<?>[] types = { Americano.class, Breve.class, Latte.class, Mocha.class, Cappuccino.class};
    private static long counter = 0;
    private final Random random = new Random();
    private final long id = counter++;
    private int size = 0;
    public CoffeeGenerator(int size) { this.size = size; }
    public CoffeeGenerator() {}
    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;
        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public boolean hasNext() {
            return count > 0;
        }

    }

    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(coffeeGenerator.next());
        }
    }
}
