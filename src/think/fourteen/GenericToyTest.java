package think.fourteen;

/**
 * @author zyw
 * @date 2020/6/15 20:39
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> fancyToyClass = FancyToy.class;
        FancyToy fancyToy = fancyToyClass.getDeclaredConstructor().newInstance();
        Class<? super FancyToy> up = fancyToyClass.getSuperclass();
        Object object = up.getDeclaredConstructor().newInstance();
    }
}
