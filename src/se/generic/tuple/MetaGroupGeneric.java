package se.generic.tuple;

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

