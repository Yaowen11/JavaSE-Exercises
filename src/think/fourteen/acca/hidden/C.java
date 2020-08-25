package think.fourteen.acca.hidden;
/**
 * @author zyw
 * @date 2020/8/3 21:04
 */
public class C implements A {
    @Override
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() { System.out.println("public C.g()");}

    void u() { System.out.println("package C.u()");}

    protected void v() { System.out.println("protected C.v()");}

    private void w() { System.out.println("private C.w()");}
}
