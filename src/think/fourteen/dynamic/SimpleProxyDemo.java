package think.fourteen.dynamic;

/**
 * @author z
 */
public class SimpleProxyDemo {
    public static void main(String[] args) {
        consumer(new RealObject());
        SimpleProxy simpleProxy = new SimpleProxy(new RealObject());
        consumer(simpleProxy);
        System.out.println("call do something count: " + simpleProxy.getCallDoSomethingCount());
        System.out.println("call something else count: " + simpleProxy.getCallSomethingElseCount());
    }
    private static void consumer(Interface in) {
        in.doSomething();
        in.somethingElse("bon");
    }
}

