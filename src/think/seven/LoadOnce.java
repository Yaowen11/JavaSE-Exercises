package think.seven;
class Loader {
    static {
        System.out.println("class is loader");
    }
    static String SAY = "hello world";
    Loader () {
        System.out.println("loader is initial");
    }
    void sayHi() {
        System.out.println("hi");
    }
}

/**
 * @author zyw
 */
public class LoadOnce {
    public static void main(String[] args) {
//        System.out.println(Loader.SAY);
        Loader loader = new Loader();
        loader.sayHi();
    }
}
