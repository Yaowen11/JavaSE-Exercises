package think.fourteen;

/**
 * @author zyw
 * @date 2020/6/21 11:44
 */
public class InterfaceViolation {
    public static void main(String[] args) {
        B a = new B();
        a.f();
        System.out.println(a.getClass().getName());
        a.g();
    }
}

interface A {
    void f();
}

class B implements A {
    @Override
    public void f() {

    }
    public void g() {}
}

