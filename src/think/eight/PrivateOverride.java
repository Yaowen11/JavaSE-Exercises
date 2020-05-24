package think.eight;

/**
 * @author zyw
 * @date 2020/5/23 12:26
 */
public class PrivateOverride {

    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride privateOverride = new Derived();
        privateOverride.f();
    }
}

class Derived extends PrivateOverride {
    public void f() {
        System.out.println("public f()");
    }
}
