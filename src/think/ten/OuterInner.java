package think.ten;

/**
 * @author zyw
 * @date 2020/5/25 22:33
 */
public class OuterInner {
    private String property = "out property ";
    private void dump() {
        System.out.println(property);
    }
    class Inner {
        void change(String change) {
            property += change;
            dump();
        }
    }
    Inner inner() {
        return new Inner();
    }
    public static void main(String[] args) {
        OuterInner outerInner = new OuterInner();
        outerInner.inner().change("hi!");
    }
}
