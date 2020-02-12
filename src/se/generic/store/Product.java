package se.generic.store;

import se.generic.generator.Generator;

import java.util.Random;

/**
 * @author zhangyaowen
 */
public class Product {
    private final int id;
    private String description;
    private double price;
    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Product> generator = new Generator<Product>() {
        private Random random = new Random(47);
        @Override
        public Product next() {
            return new Product(random.nextInt(1000), "Test", Math.round(random.nextDouble() * 1000.0) + 0.99);
        }
    };
}
