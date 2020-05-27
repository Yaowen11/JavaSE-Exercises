package think.ten;

/**
 * @author z
 * @date 2020/5/27 17:09
 */
public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() { System.out.println("BigEgg.Yolk()"); }
    }
    public static void main(String[] args) {
        new BigEgg();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

class Egg {
    private Yolk y;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    public Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}