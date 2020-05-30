package think.eleven;

/**
 * @author z
 * @date 2020/5/28 17:13
 */
public class Gala implements Fruit {
    @Override
    public Taste taste() {
        return Taste.ACID;
    }

    @Override
    public int compareTo(Fruit o) {
        return Integer.compare(taste().ordinal(), o.taste().ordinal());
    }
}
