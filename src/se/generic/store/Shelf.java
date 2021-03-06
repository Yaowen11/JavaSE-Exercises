package se.generic.store;

import se.generic.generation.Generators;

import java.util.ArrayList;

/**
 * @author zhangyaowen
 */
public class Shelf extends ArrayList<Product> {
    public Shelf(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}
