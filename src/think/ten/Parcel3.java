package think.ten;

/**
 * @author zyw
 * @date 2020/5/25 22:06
 */
public class Parcel3 {
    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }
    class Destination {
        private String label;
        Destination(String label) {
            this.label = label;
        }
        String read() {
            return label;
        }
    }
    public static void main(String[] args) {
        Parcel3 parcel3 = new Parcel3();
        Parcel3.Contents contents = parcel3.new Contents();
        System.out.println(contents.value());
        Parcel3.Destination destination = parcel3.new Destination("hello");
        System.out.println(destination.read());
    }
}
