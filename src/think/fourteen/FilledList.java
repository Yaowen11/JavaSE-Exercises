package think.fourteen;

import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyw
 * @date 2020/6/15 19:59
 */
public class FilledList<T> {

    private final Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElement) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < nElement; i++) {
            try {
                result.add(type.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException |
                    InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> filledList = new FilledList<>(CountedInteger.class);
        System.out.println(filledList.create(15));
        FilledList<String> stringFilledList = new FilledList<>(String.class);
        System.out.println(stringFilledList.create(3));
        System.out.println("0000000000000000".getBytes(StandardCharsets.UTF_8).length);
    }
}

class CountedInteger {
    private static long counter;
    private final long id = counter++;
    @Override public String toString() { return Long.toString(id); }
}


