package lam;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zyw
 * @date 2020/10/18 21:29
 */
public class FunctionDemo {
    public static void main(String[] args) {
        FunctionDemo demo = new FunctionDemo();
        demo.functionInterfaceDump();
        demo.functionPredicate();
        demo.functionSupplier();
        demo.functionConsumer();
    }
    public void functionInterfaceDump() {
        Function<Integer, Double> m = new Function<Integer, Double>() {
            @Override
            public Double apply(Integer integer) {
                return 1.6 * integer;
            }
        };
        System.out.println(m.apply(3));
    }

    public void functionPredicate() {
        Predicate<String> numbersOnly = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                try {
                    Integer.parseInt(s);
                    return true;
                } catch (NumberFormatException numberFormatException) {
                    return false;
                }
            }
        };
        System.out.println(numbersOnly.test("23"));
    }

    public void functionSupplier() {
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return ThreadLocalRandom.current().nextInt();
            }
        };
        System.out.println(supplier.get());
    }

    public void functionConsumer() {
        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        stringConsumer.accept(System.getProperty("OS"));
    }
}
