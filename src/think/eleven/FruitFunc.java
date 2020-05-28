package think.eleven;

import java.util.Random;

/**
 * @author z
 * @date 2020/5/28 17:15
 */
public class FruitFunc {

    public static FruitFunc fruitFactory = new FruitFunc();

    private FruitFunc(){}

    private final Random random = new Random();

    public Fruit getFruit() {
        switch (random.nextInt() % 3) {
            case 0:
                return new Apple();
            case 1:
                return new Orange();
            default:
                return new Gala();
        }
    }
}
