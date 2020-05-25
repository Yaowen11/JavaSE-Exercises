package think.nine;

/**
 * @author z
 * @date 2020/5/25 16:46
 */
public class Shapes {
    public static double cycle(CycleFactory factory) {
        return factory.getCycle().shapeCycle();
    }
    public static void main(String[] args) {
        System.out.println(cycle(new UnicycleFactory()));
        System.out.println(cycle(new BicycleFactory()));
        System.out.println(cycle(new TricycleFactory()));
    }
}

interface Cycle {
    double shapeCycle();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    @Override public double shapeCycle() {
        return 22.02;
    }
}

class Bicycle implements Cycle {
    @Override
    public double shapeCycle() {
        return 12.03;
    }
}

class Tricycle implements Cycle {
    @Override
    public double shapeCycle() {
        return 23.03;
    }
}

class UnicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class TricycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}
