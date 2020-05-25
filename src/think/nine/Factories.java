package think.nine;

/**
 * @author z
 * @date 2020/5/25 16:16
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory factory) {
        Service s = factory.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args) {
        serviceConsumer(new ImplementationFactory());
        serviceConsumer(new ImplementationFactory());
    }
}

interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class ServiceImpl implements Service {
    @Override public void method1() {
        System.out.println("Implementation method1");
    }
    @Override public void method2() {
        System.out.println("Implementation method2");
    }
}

class ImplementationFactory implements ServiceFactory {
    @Override public Service getService() {
        return new ServiceImpl();
    }
}

class Service1Impl implements Service {
    @Override public void method1() {
        System.out.println("Implementation2 method1");
    }
    @Override public void method2() {
        System.out.println();
    }
}

class Implementation1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Service1Impl();
    }
}



