package think.fourteen;

/**
 * @author z
 */
public class SimpleProxyDemo {
    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
    private static void consumer(Interface in) {
        in.doSomething();
        in.somethingElse("bon");
    }
}

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SomethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;
     public SimpleProxy(Interface proxied) {
         this.proxied = proxied;
     }

    @Override
    public void doSomething() {
         System.out.println("Simple Proxy do something");
         proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("Simple Proxy some thing else " + arg);
        proxied.somethingElse(arg);
    }
}
