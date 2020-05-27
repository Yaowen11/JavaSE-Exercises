package think.ten;

/**
 * @author z
 * @date 2020/5/27 13:57
 */
public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return 0;
        }
    }
    protected static class ParcelDestination implements Destination {
        private String label;
        private ParcelDestination(String whereTo) {
            label = whereTo;
        }
        @Override public String readLabel() {
            return label;
        }
        public static void f() {}
        static int x = 10;
        static class AnotherLevel {
            public static void f(){}
            static int x = 10;
        }
    }
    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }
    public static Contents contents() {
        return new ParcelContents();
    }
    public static void main(String[] strings) {
        Contents contents = contents();
        Destination destination = destination("static");
        System.out.println(contents.value());
        System.out.println(destination.readLabel());
    }
}
