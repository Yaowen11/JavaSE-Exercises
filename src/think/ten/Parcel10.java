package think.ten;

/**
 * @author z
 * @date 2020/5/27 11:17
 */
public class Parcel10 {
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budgst!");
                }
            }
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }
    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        Destination d = parcel10.destination("Tent", 101.395f);
    }
}
