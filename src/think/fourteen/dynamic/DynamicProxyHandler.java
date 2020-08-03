package think.fourteen.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class DynamicProxyHandler implements InvocationHandler {

    private Object proxid;

    public static int doSomethingCount = 0;

    public static int doSomethingElseCount = 0;

    public DynamicProxyHandler(Object o) {
        proxid = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy);
        System.out.println("proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println("  " + arg);
            }
        }
        if ("doSomething".equals(method.getName())) {
            doSomethingCount++;
        }
        if ("somethingElse".equals(method.getName())) {
            doSomethingElseCount++;
        }
        return method.invoke(proxid, args);
    }
}
