package think.ten;

/**
 * @author zyw
 * @date 2020/5/25 20:40
 */
public class Outer {
    class Inner {
        void inner() {
            System.out.println("is inner");
        }
    }
    public Inner inner() {
        return new Inner();
    }
    public static void main(String[] args) {
        Inner inner = new Outer().inner();
        System.out.println(inner.getClass());
    }
}
