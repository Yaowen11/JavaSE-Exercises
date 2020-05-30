package think.ten;

import java.util.Date;

/**
 * @author zyw
 * @date 2020/5/27 19:53
 */
public class OverrideFunc extends BaseFunc {
    @Override
    protected void dumpI(Integer integer) {
        System.out.println(Integer.toBinaryString(integer));
    }

    public void dumpS(Date date) {
        String s = date.toString();
        System.out.println(System.out.printf("this is extension %s", s));
    }

    public static void main(String[] args) {
        OverrideFunc overrideFunc = new OverrideFunc();
        overrideFunc.dumpI(100);
        overrideFunc.dumpS("hello");
    }
}

class BaseFunc {
    protected void dumpS(String s) {
        System.out.println(s);
    }
    protected void dumpI(Integer integer) {
        System.out.println(integer);
    }
}
