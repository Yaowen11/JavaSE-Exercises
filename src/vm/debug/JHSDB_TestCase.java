package vm.debug;

/**
 * @author z
 * @date 2020/5/27 9:16
 * -Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
 */
public class JHSDB_TestCase {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();
        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }
    private static class ObjectHolder {}
    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }

}
