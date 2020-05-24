package think.eight;

/**
 * @author zyw
 * @date 2020/5/23 11:34
 */
public class Cycle {
    void ride() {
        System.out.println("cycle.ride()");
    }
    public static void main(String[] args) {
        Cycle cycle = new Unicycle();
        cycle.ride();
    }
}

class Unicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Unicycle.ride");
    }
}

class Bicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Bicycle.ride");
    }
}

class Tricycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Tricycle.ride");
    }
}