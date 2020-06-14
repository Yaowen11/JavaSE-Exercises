package think.fourteen;

import java.util.Random;

/**
 * @author zyw
 * @date 2020/6/14 21:20
 */
public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main(String[] args) {
        Class<Initable> initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticfinal);
        System.out.println(Initable.staticfinal2);
        try {
            Class initable3Class = Class.forName("think.fourteen.Initable3");
            System.out.println("After creating Initable3 ref");
            System.out.println(Initable3.staticNonFinal);
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

    }
}

class Initable {
    static final int staticfinal = 47;
    static final int staticfinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

