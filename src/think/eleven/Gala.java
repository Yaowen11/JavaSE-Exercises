package think.eleven;

/**
 * @author z
 * @date 2020/5/28 17:13
 */
public class Gala implements Fruit {
    @Override
    public String taste() {
        return Taste.SWEET_AND_ACID.name();
    }
}
