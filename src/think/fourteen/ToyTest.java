package think.fourteen;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zyw
 * @date 2020/6/14 20:41
 */
public class ToyTest {
    static <T> void printInfo(Class<T> cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class tClass = null;
        try {
            tClass = Class.forName("think.fourteen.FancyToy");
        } catch (ClassNotFoundException exception) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(tClass);
        for (Class face: tClass.getInterfaces()) {
            printInfo(face);
        }
        Class up = tClass.getSuperclass();
        Object obj = null;
        try {
            try {
                obj = up.getDeclaredConstructor().newInstance();
            } catch (InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

interface HasBatteries {}

interface Waterproof {}

interface Shoots {}

class Toy {
//    Toy(){}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() { super(1);}
}


