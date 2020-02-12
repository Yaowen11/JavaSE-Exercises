package se.generic;

/**
 * @author zhangyaowen
 */
public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        ClassAsFactory<Integer> factory = new ClassAsFactory<>(Integer.class);
    }
}
