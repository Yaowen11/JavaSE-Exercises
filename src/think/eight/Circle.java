package think.eight;

/**
 * @author zyw
 * @date 2020/5/23 11:48
 */
public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw() " + wheels());
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase()");
    }

    @Override
    public void dump() {
        System.out.println("Circle.dump()");
    }

    private Integer wheels() {
        return 4;
    }
}
