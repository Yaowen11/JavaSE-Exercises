package se.generic.store;

import java.util.ArrayList;

/**
 * @author zhangyaowen
 */
public class Aisle extends ArrayList<Shelf> {
    public Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}
