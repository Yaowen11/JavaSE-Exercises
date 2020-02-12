package se.generic;

class Base {}
class Derived extends Base{}
interface OrdinaryGetter {
    Base get();
}
interface DerivedGetter extends OrdinaryGetter {
    @Override
    Derived get();
}

/**
 * @author zhangyaowen
 */
public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived derived = d.get();
    }
}
