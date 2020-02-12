package se.generic;

import se.generic.generator.Generator;

/**
 * @author zhangyaowen
 */
public class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer() {}

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
    public static Generator<Customer> generator() {
        return Customer::new;
    }
}
