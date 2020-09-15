package vm.load;

import java.lang.reflect.Field;

/**
 * @author z
 */
public class ClassTest {
    private static int[] array = new int[3];
    private static int length = array.length;

    private static Class<One> one = One.class;
    private static Class<Another> another = Another.class;

    public static void main(String[] args) throws Exception {
        One oneObj = one.getDeclaredConstructor().newInstance();
        oneObj.call();

        Another anotherObj = another.getDeclaredConstructor().newInstance();
        anotherObj.speak();

        Field privateFieldInOne = one.getDeclaredField("inner");
        privateFieldInOne.setAccessible(true);
        privateFieldInOne.set(oneObj, "world changed");
        System.out.println(oneObj.getInner());

        ClassLoader c = ClassTest.class.getClassLoader();
        ClassLoader cp = c.getParent();
        ClassLoader cpp = cp.getParent();
        System.out.printf("app loader: %s, extension loader: %s, boot loader: %s\n", c.getName(), cp.getName(), cpp == null);
    }
}

class One {

    private String inner = "time flies.";

    public void call() {
        System.out.println("hello world.");
    }

    public String getInner() {
        return inner;
    }
}

class Another {
    public void speak() {
        System.out.println("easy coding.");
    }
}
