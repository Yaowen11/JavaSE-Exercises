package think.eight;

/**
 * @author zyw
 * @date 2020/5/23 11:50
 */
public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }
}
