package se.generic;

import se.generic.generator.Generator;
import se.generic.generator.Generators;

import java.util.*;

/**
 * @author zhangyaowen
 */
public class Teller {
    private static long counter = 1;
    private final long id = counter++;
    private Teller() {}

    @Override
    public String toString() {
        return "Teller " + id;
    }

    public static Generator<Teller> generator = Teller::new;

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c: line) {
            serve(tellers.get(rand.nextInt(tellers.size())), c);
        }

    }

    private static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }
}
