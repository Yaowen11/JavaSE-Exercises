package se.generic.wildcard;

/**
 * @author z
 */
public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        fruits[0] = new Fruit();
        System.out.println(fruits);
        fruits[1] = new Orange();
    }
}
