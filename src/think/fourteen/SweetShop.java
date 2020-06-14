package think.fourteen;

/**
 * @author zyw
 * @date 2020/6/14 20:04
 */
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        try {
            Class.forName("think.fourteen.Candy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Candy {
    static { System.out.println("Loading Candy");}
}

class Gum {
    static { System.out.println("Loading Gum");}
}

class Cookie {
    static { System.out.println("Loading Cookie"); }
}
