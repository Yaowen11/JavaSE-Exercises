package think.eight;

/**
 * @author zyw
 * @date 2020/5/23 20:08
 */
public class RoundGlyph extends Clyph{
    private int radius = 1;
    RoundGlyph(int i) {
        radius = i;
        System.out.println("RoundGlyph.RoundGlyph(). radius = " + radius);
    }
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

class Clyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }
    Clyph () {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}
