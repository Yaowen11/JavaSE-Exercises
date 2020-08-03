package think.fourteen.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class MethodSelector implements InvocationHandler {
    private Object proxied;
    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("interesting".equals(method.getName())) {
            System.out.println("Proxy deleted the interesting method");
        }
        return method.invoke(proxied, args);
    }
}
