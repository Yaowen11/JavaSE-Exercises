package think.fifteen.genericinterface;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zyw
 * @date 2020/8/22 20:25
 */
public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind) { this.kind = kind; }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringArrayMaker = new ArrayMaker<>(String.class);
        String[] strings = stringArrayMaker.create(3);
        System.out.println(Arrays.toString(strings));
        String[] strings1 = (String[]) Array.newInstance(String.class, 10);

    }
}
