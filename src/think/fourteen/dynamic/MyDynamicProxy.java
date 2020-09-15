package think.fourteen.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicProxy {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);
//        Hello proxyHello = (Hello) Proxy.newProxyInstance(
//                HelloImpl.class.getClassLoader(),
//                HelloImpl.class.getInterfaces(),
//                handler
//        );
//        proxyHello.sayHello();
        Hello proxyHello1 = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                (proxy, method, args1) -> {
                    System.out.println("lambda: ");
                    return method.invoke(hello, args1);
                }
        );
        proxyHello1.sayHello();
    }
}

interface Hello {
    void sayHello();
}

class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello world");
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking sayHello");
        return method.invoke(target, args);
    }
}
