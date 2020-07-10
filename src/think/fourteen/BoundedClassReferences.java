package think.fourteen;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zyw
 * @date 2020/7/5 7:35
 */
public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = int.class;
        List<Class<? extends Father>> classes = new LinkedList<>();
        classes.add(Father.class);
        classes.add(Son.class);
        classes.add(SubSon.class);
        A1<String> a1 = new A1<>("hello");
        a1.setTs(new String[]{"1", "2", "3"});

    }
}

class Father {}

class Son extends Father {}

class SubSon extends Son {}

class A1 <T> {
    private T t;
    private T[] ts;
    public A1(T t) {
        this.t = t;
    }

    public T[] getTs() {
        return ts;
    }

    public void setTs(T[] ts) {
        this.ts = ts;
    }
}

