package think.eleven;

/**
 * @author z
 * @date 2020/5/28 16:54
 */
public class Apple implements Fruit {
    private static long counter = 0;
    private final long id = counter++;
    public long getId() {
        return id;
    }

    @Override
    public String taste() {
        return Taste.SWEET.toString();
    }
}
