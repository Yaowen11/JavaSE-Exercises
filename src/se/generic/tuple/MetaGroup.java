package se.generic.tuple;

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
