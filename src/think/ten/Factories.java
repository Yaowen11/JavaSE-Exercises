package think.ten;

/**
 * @author z
 * @date 2020/5/27 13:31
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory serviceFactory) {
        Service service = serviceFactory.getService();
        System.out.println(service);
        service.method1();
        service.method2();
    }
    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
        serviceConsumer(Implementation2.factory);
    }
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {
    private Implementation1() {

    }

    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2");
    }
    public static ServiceFactory factory = Implementation1::new;
}

class Implementation2 implements Service {

    private Implementation2(){}

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }
    public static ServiceFactory factory = Implementation2::new;
}