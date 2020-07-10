package think.fourteen;

/**
 * @author zyw
 * @date 2020/6/15 19:52
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intClass = double.class;
        Class<?> intClass1 = int.class;
        intClass1 = double.class;
        BoundedClassReferences.main();
    }

    static public class BoundedClassReferences {
        public static void main() {
            Class<? extends Number> bounded = int.class;
            bounded = double.class;
            bounded = Number.class;
        }
    }
}
