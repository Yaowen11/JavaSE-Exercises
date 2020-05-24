package think.eight;

/**
 * @author zyw
 * @date 2020/5/23 11:49
 */
public class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Square.erase()");
    }
}
