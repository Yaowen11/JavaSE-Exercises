package think.ten;

/**
 * @author z
 * @date 2020/5/27 14:15
 */
public interface ClassInInterface {
    /**
     * inner
     */
    void howdy();
    class Test implements ClassInInterface {
        @Override public void howdy() {
            System.out.println("Howdy!");
        }
        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
