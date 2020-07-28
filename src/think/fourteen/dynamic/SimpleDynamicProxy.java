package think.fourteen.dynamic;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
    public static void consumer(Interface inface) {
        inface.doSomething();
        inface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class },
                new DynamicProxyHandler(realObject)
        );
        consumer(proxy);
        System.out.printf(
                "do something Count %d, something else count %d \n",
                DynamicProxyHandler.doSomethingCount,
                DynamicProxyHandler.doSomethingElseCount
        );
    }
}

