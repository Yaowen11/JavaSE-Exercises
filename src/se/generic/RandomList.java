package se.generic;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author zhangyaowen
 */
public class RandomList<T> {

    private ArrayList<T> storage = new ArrayList<>();

    private Random random = new Random(39);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public int size() {
        return storage.size();
    }

    public static void main(String[] args) {
        String init = "The quick brown fox jumped over the lazy brown dog";
        String regex = " ";
        RandomList<String> rs = new RandomList<>();
        for (String s: init.split(regex)) {
            rs.add(s);
        }
        for (int i = 0; i < rs.size(); i++) {
            System.out.print(rs.select() + " ");
        }
    }
}
