package think.eleven;

/**
 * @author zyw
 * @date 2020/5/28 20:41
 */
public class Hawthorn implements Fruit {
    @Override
    public int compareTo(Fruit o) {
        return Integer.compare(taste().ordinal(), o.taste().ordinal());
    }

    @Override
    public Taste taste() {
        return Taste.ACID_AND_SWEET;
    }
}
