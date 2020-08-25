package think.fourteen.acca.hidden;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zyw
 * @date 2020/8/3 21:07
 */
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
//        A a = HiddenC.makeA();
        A a = InnerA.makeA();
        a.f();
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }
    static void callHiddenMethod(Object o, String method) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method g = o.getClass().getDeclaredMethod(method);
        g.setAccessible(true);
        g.invoke(o);
    }
}
