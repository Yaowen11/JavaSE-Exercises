package think.ten;

/**
 * @author z
 * @date 2020/5/27 14:21
 */
public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnab = mnaa.new B();
        mnab.h();
    }
}

class MNA {
    private void f() {}
    class A {
        private void g() {}
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}
