package se.generic.tuple;

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
