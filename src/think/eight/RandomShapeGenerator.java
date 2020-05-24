package think.eight;

import java.util.Random;

/**
 * @author zyw
 * @date 2020/5/23 11:51
 */
public class RandomShapeGenerator {
    private final Random random = new Random();
    public Shape next() {
        Shape shape;
        switch (random.nextInt(3)) {
            default:
            case 0: shape = new Circle(); break;
            case 1: shape = new Square(); break;
            case 2: shape = new Triangle(); break;
        }
        return shape;
    }
}
