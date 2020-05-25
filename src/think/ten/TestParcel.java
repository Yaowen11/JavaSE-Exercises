package think.ten;

import java.util.Random;

/**
 * @author zyw
 * @date 2020/5/25 22:17
 */
public class TestParcel {
    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        Contents c = parcel4.contents();
        System.out.println(c.value());
        Destination d = parcel4.destination("Tasmania");
        System.out.println(d.readLabel());
    }
}

class Parcel4 {

    protected class DestinationImpl implements Destination {
        private String label;
        DestinationImpl(String label) {
            this.label = label;
        }
        @Override
        public String readLabel() {
            return label;
        }
    }

    private class ContentsImpl implements Contents {
        private int i = new Random().nextInt();
        @Override
        public int value() {
            return i;
        }
    }

    public Destination destination(String s) {
        return new DestinationImpl(s);
    }

    public Contents contents() {
        return new ContentsImpl();
    }
}
