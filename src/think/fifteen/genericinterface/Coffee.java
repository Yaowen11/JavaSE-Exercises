package think.fifteen.genericinterface;

/**
 * @author zyw
 * @date 2020/6/22 20:53
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
