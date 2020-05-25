package think.ten;

/**
 * @author zyw
 * @date 2020/5/25 20:22
 */
public class Parcell {

    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() {
            return label;
        }
    }

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcell parcell = new Parcell();
        parcell.ship("Tasmania");
    }
}
