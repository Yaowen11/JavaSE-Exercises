package se.generic.tuple;

class MetaGroupTest {
    static MetaGroupGenericC<String, Integer> f() {
        return new MetaGroupGenericC<>("hi", 47);
    }
    static MetaGroupGeneric<Integer, String, Boolean> metaGroupGeneric() {
        return new MetaGroupGeneric<>(23, "Hello", true);
    }
}
