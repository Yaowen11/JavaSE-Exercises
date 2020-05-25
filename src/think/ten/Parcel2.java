package think.ten;

/**
 * @author zyw
 * @date 2020/5/25 20:29
 */
public class Parcel2 {
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
        String readLine() {
            return label;
        }
    }
    public Destination to(String s) {
        return new Destination(s);
    }
    public Contents size() {
        return new Contents();
    }
    public void ship(String dest) {
        Contents contents = size();
        Destination destination = to(dest);
        System.out.println(destination.readLine());
    }
    public static void main(String[] args) {
        Parcel2 parcel2 = new Parcel2();
        parcel2.ship("Tasmania");
        Parcel2 q = new Parcel2();
        Parcel2.Contents c = q.size();
        Parcel2.Destination d = q.to("Borneo");
    }
}