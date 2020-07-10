package think.fifteen.genericfunction;

import think.fifteen.genericinterface.CoffeeGenerator;

import java.math.BigDecimal;

/**
 * @author zyw
 * @date 2020/6/22 21:44
 */
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public <T,E,U> void three(T t, E e, U u) {
        System.out.printf("T type of %s, E type of %s U type of %s\n", t.getClass().getName(), e.getClass().getName(), u.getClass().getName());
    }

    public <T, U> void two(T t, U u, String s) {
        System.out.printf("T type of %s, E type of %s U type of %s\n", t.getClass().getName(), s, u.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f(new CoffeeGenerator().next());
        genericMethods.f(1);
        genericMethods.f(1.0f);
        genericMethods.f(1.0d);
        genericMethods.f(2e33);
        System.out.println(BigDecimal.valueOf(2e33).toPlainString());
        genericMethods.three("a", 2, new CoffeeGenerator().next());
        genericMethods.two("a", new CoffeeGenerator().next(), "asa");
    }
}
