package se.generic;

/**
 * @author zhangyaowen
 * @param <T>
 */
public class ClassTypeCapture<T> {
    Class<T> kind;
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }
    public static void main(String[] args) {
        ClassTypeCapture<Building> classTypeCapture = new ClassTypeCapture<>(Building.class);
        System.out.println(classTypeCapture.f(new Building()));
        System.out.println(classTypeCapture.f(new House()));
        ClassTypeCapture<House> classTypeCapture1 = new ClassTypeCapture<>(House.class);
        System.out.println(classTypeCapture1.f(new Building()));
        System.out.println(classTypeCapture1.f(new House()));
    }
}

class Building {};
class House extends Building {}