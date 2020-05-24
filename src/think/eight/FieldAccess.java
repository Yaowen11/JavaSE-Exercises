package think.eight;

/**
 * @author zyw
 * @date 2020/5/23 19:44
 */
public class FieldAccess {
    public static void main(String[] args) {
        Super sp = new Sub();
        System.out.println("sup.field = " + sp.field + ". sup.getField() = " + sp.getField());
        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field + ", sub.getField() = " + sub.getField() + ". sub.getSuperField() = " + sub.getSuperField());
    }
}

class Super {
    public int field = 0;
    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;
    public int getField() {
        return field;
    }
    public int getSuperField() {
        return super.field;
    }
}