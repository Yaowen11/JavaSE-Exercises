package think.ten;

/**
 * @author z
 * @date 2020/5/27 11:55
 */
public class InnerAnonymous {
    private static class A {
        private Integer integer;
        A(Integer integer) {
            this.integer = integer;
        }
        public Integer getInteger() {
            return integer;
        }
    }
    private static class B {
        A getA(int i) {
            return new A(i);
        }
    }
    public static void main(String[] args) {
        InnerAnonymous innerAnonymous = new InnerAnonymous();
        InnerAnonymous.B b = new InnerAnonymous.B();
        A a = b.getA(23);
        System.out.println(a.getInteger());
    }
}
