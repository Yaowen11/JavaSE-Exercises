package think.eleven;

/**
 * @author z
 * @date 2020/5/28 16:56
 */
public class Orange implements Fruit {
    @Override
    public Taste taste() {
        return Taste.SWEET_AND_ACID;
    }

    @Override
    public int compareTo(Fruit o) {
        return Integer.compare(taste().ordinal(), o.taste().ordinal());
    }
}
