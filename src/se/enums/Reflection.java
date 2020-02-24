package se.enums;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhangyaowen
 */
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("----- analyzing -----");
        System.out.println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m: enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }
    public static void main(String[] args) {
        Set<String> ozWitchClass = analyze(OzWitch.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("method is == " + ozWitchClass.containsAll(enumMethods));
        System.out.println("Explore.removeAll(Enum)" + ozWitchClass.removeAll(enumMethods));
        System.out.println(ozWitchClass);
        System.out.println(enumMethods);
    }
}
