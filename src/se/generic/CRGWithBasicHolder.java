package se.generic;

class BasicHolder<T> {
    T element;
    void set(T arg) {
        element = arg;
    }
    T get() {
        return element;
    }
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
class Subtype extends BasicHolder<Subtype> {}
class Other{}
class BasicOther extends BasicHolder<Other> {}
/**
 * @author zhangyaowen
 */
public class CRGWithBasicHolder {
    public static void main(String[] args) {
        BasicOther b = new BasicOther();
        BasicOther b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
}
