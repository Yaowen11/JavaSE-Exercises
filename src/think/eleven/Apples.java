package think.eleven;

import java.util.ArrayList;

/**
 * @author z
 * @date 2020/5/28 16:51
 */
public class Apples {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.forEach(apple -> {System.out.println(apple.getId());});
        ArrayList<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fruits.add(FruitFunc.fruitFactory.getFruit());
        }
        fruits.forEach(
                fruit ->
                    {if (fruit instanceof Apple) {
                        System.out.println(((Apple) fruit).getId());
                    } else {
                        System.out.println(fruit.getClass().getSimpleName() + fruit.taste());
                    }
                });
    }
}
