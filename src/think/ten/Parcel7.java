package think.ten;

import java.util.Random;

/**
 * @author zyw
 * @date 2020/5/26 21:27
 */
public class Parcel7 {
    public Contents contents() {
        return () -> new Random().nextInt();
    }
    public Destination destination(String s) {
        return () -> s;
    }
    public Wrapping wrapping(int x) {
        return new Wrapping(x) {
            @Override
            public int value() {
                return super.value() * 2;
            }
        };
    }
    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7();
        Contents contents = parcel7.contents();
        System.out.println(contents.value());
        Destination destination = parcel7.destination("hello");
        System.out.println(destination.readLabel());
        Wrapping wrapping = parcel7.wrapping(20);
        System.out.println(wrapping.value());
    }
}
