package se.generic.generator;

import se.generic.generation.Fibonacci;
import se.generic.generation.Coffee;
import se.generic.generation.Generator;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangyaowen
 * @param <T>
 */
public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }

    public static void main(String[] args) {
        BasicGenerator<Fibonacci> fibonacciBasicGenerator = (BasicGenerator<Fibonacci>) BasicGenerator.create(Fibonacci.class);
        Fibonacci fibonacci = fibonacciBasicGenerator.next();
        int length = 12;
        for (int i = 1; i <= length; i++) {
            System.out.print(fibonacci.next() + " ");
        }
        System.out.println();
        BasicGenerator<Coffee> coffeeBasicGenerator = (BasicGenerator<Coffee>) BasicGenerator.create(Coffee.class);
        for (int i = 0; i < length; i++) {
            System.out.print(coffeeBasicGenerator.next() + " ");
        }
        System.out.println();
        BasicGenerator<Fibonacci> fibG = new BasicGenerator<>(Fibonacci.class);
        Fibonacci fib = fibG.next();
        for (int i = 0; i < length; i++) {
            System.out.print(fib.next() + " ");
        }
    }
}
