package think.eleven;

/**
 * @author z
 * @date 2020/5/28 16:56
 */
public class Orange implements Fruit {
    @Override
    public String taste() {
        return Taste.SWEET_AND_ACID.name();
    }
}
