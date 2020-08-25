package think.fourteen.acca.hidden;

/**
 * @author zyw
 * @date 2020/8/3 20:57
 */
public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
//            B b = (B) a;
//            b.g();
            ((B) a).g();
        }
    }
}
