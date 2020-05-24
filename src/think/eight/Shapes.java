package think.eight;

/**
 * @author zyw
 * @date 2020/5/23 11:56
 */
public class Shapes {
    private static RandomShapeGenerator shapeGenerator = new RandomShapeGenerator();
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = shapeGenerator.next();
        }
        for (Shape shape: shapes) {
            System.out.println(shape.getClass().getSimpleName());
            shape.draw();
        }
    }
}
