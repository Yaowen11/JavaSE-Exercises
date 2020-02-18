package se.generic.generator;

import se.generic.generation.Generator;

import java.util.Iterator;

/**
 * @author zhangyaowen
 */
public class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++, "" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }
        };
    }

    public static void main(String[] args) {
        int count = 3;
        System.out.println(MapData.map(new Letters(), count));
        System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), count));
        System.out.println(MapData.map(new CountingGenerator.Character(), "value", count));
        System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));
        System.out.println(MapData.map(new Letters(), "Pop"));
    }
}
