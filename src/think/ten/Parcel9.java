package think.ten;

/**
 * @author z
 * @date 2020/5/27 11:08
 */
public class Parcel9 {
    public Destination destination(String dest) {
        return new Destination() {
            final private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }
    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination destination = parcel9.destination("Ta");
    }
}
