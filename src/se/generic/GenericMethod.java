package se.generic;

/**
 * @author zhangyaowen
 */
public class GenericMethod {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.f("String");
        genericMethod.f(11);
        genericMethod.f(new int[]{1, 2, 3, 4});
        genericMethod.f('C');
        genericMethod.f(genericMethod);
        genericMethod.f(false);
    }
}
