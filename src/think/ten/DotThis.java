package think.ten;

/**
 * @author zyw
 * @date 2020/5/25 21:31
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }
    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }
    public Inner inner() {
        return new Inner();
    }
    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        DotThis.Inner dt = dotThis.inner();
        dt.outer().f();
        DotNew dotNew = new DotNew();
        DotNew.Inner inner = dotNew.new Inner();
        DotNew.StaticInner staticInner = new DotNew.StaticInner();
    }
}
