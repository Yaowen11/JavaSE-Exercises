package se.generic;

/**
 * @author zhangyaowen
 * @param <A>
 * @param <B>
 * @param <C>
 */
public class MetaGroupGeneric<A, B, C> extends MetaGroupGenericC<A, B> {

    public final C third;

    public MetaGroupGeneric(A a, B b, C third) {
        super(a, b);
        this.third = third;
    }

    @Override
    public String toString() {
        return super.toString() + "MetaGroupGeneric{" +
                "third=" + third +
                '}';
    }

    public MetaGroupGenericC<A,B> useMeta() {
        return new MetaGroupGenericC<>(first, second);
    }

    public static void main(String[] args) {
        MetaGroupGeneric<Integer, String, Boolean> metaGroupGeneric = MetaGroupTest.metaGroupGeneric();
        System.out.println(metaGroupGeneric.toString());
    }
}

class MetaGroupTest {
    static MetaGroupGenericC<String, Integer> f() {
        return new MetaGroupGenericC<>("hi", 47);
    }
    static MetaGroupGeneric<Integer, String, Boolean> metaGroupGeneric() {
        return new MetaGroupGeneric<>(23, "Hello", true);
    }
}

class A {}

class B { }

class MetaGroup {

    public final A first;

    public final B second;

    public MetaGroup(A first, B second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class MetaGroupGenericC<A, B> {
    public final A first;
    public final B second;

    MetaGroupGenericC(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "MetaGroupGeneric{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}

