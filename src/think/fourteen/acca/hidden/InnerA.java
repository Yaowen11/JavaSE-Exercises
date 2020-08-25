package think.fourteen.acca.hidden;

/**
 * @author zyw
 * @date 2020/8/3 21:16
 */
class InnerA {
    private static class C1 implements A {
        @Override public void f() { System.out.println("public C1.f()"); }
        public void g() { System.out.println("public C1.g()"); }
        void u() { System.out.println("package C1.u()");}
        protected void v() { System.out.println("protected C1.v()"); }
        private void w() { System.out.println("private C.w()"); }
    }
    public static A makeA() { return new C1(); }
}
