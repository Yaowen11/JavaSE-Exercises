package think.ten;

/**
 * @author zyw
 * @date 2020/5/25 21:42
 */
public class DotNew {
    public class Inner {}
    static class StaticInner {}
    public static void main(String[] args) {
        DotNew dotNew = new DotNew();
        DotNew.Inner dni = dotNew.new Inner();
        DotNew.StaticInner staticInner = new DotNew.StaticInner();
    }
}
