package think.ten;

/**
 * @author zyw
 * @date 2020/5/26 21:13
 */
public class Parcel5 {
    private String out = "hello I'm outer";
    public Destination destination(String s) {
        final int inner = 0xffffff;
        class DestinationImpl implements Destination {
            private String label;
            DestinationImpl(String s) { label = s; }
            @Override
            public String readLabel() {
                return out + label + ":" + inner;
            }
        }
        return new DestinationImpl(s);
    }
    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destination destination = parcel5.destination("Te");
        System.out.println(destination.readLabel());
    }
}
