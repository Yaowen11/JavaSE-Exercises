package think.ten;

/**
 * @author zyw
 * @date 2020/5/25 22:37
 */
public class AccessInnerPrivate {
    class Inner {
        private String property = "inner property ";
        void setProperty(String string) {
            property += string;
        }
        String getProperty() {
            return property;
        }
    }
    public static void main(String[] args) {
        AccessInnerPrivate accessInnerPrivate = new AccessInnerPrivate();
        AccessInnerPrivate.Inner inner = accessInnerPrivate.new Inner();
        System.out.println(inner.property);
    }
}
