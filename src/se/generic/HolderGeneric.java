package se.generic;

import java.lang.reflect.Type;

class Automobile {
    @SafeVarargs
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }
}
/**
 * @author zhangyaowen
 */
class Holder {

    private Object a;

    Holder(Object a) {
        this.a = a;
    }

    public void set(Object a) {
        this.a = a;
    }

    public Object get() {
        return a;
    }

    public static void main(String[] args) {
        Holder h2 = new Holder(new Automobile());
        Automobile a = (Automobile) h2.get();
        h2.set("Not an Automobile");
        String s = (String) h2.get();
        h2.set(1);
        Integer x = (Integer) h2.get();
    }
}

/**
 * generic
 * @author zhangyaowen
 * @param <T>
 */
public class HolderGeneric<T> {

    private T a;

    HolderGeneric(T a) {
        this.a = a;
    }

    void set(T a) {
        this.a = a;
    }

    T get() {
        return a;
    }

    public static void main(String[] args) {
        HolderGeneric<Automobile> holderGeneric = new HolderGeneric<>(new Automobile());
        Automobile a = holderGeneric.get();
        Holder.main(args);
        GenericClass.main(args);
    }
}

class GenericClass<T, E> {
    private T t;
    private E e;

    GenericClass(T t, E e) {
        setT(t);
        setE(e);
    }

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setE(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }


    public static void main(String[] args) {
        GenericClass<Integer, String> genericClass = new GenericClass<>(1, "hello");
        genericClass.setE(Integer.toString(23) + "hello");
        genericClass.setT(Integer.parseInt(args[0]));
        System.out.println(genericClass.getE());
        System.out.println(genericClass.getT());
        String middle = Automobile.<String>getMiddle("John", "Q.", "Public");
        System.out.println(middle);
        Integer mid = Automobile.<Integer>getMiddle(1, 2, 3, 4, 5);
        System.out.println(mid);
    }
}