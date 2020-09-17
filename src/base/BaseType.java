package base;

public class BaseType {
    private volatile int base = 0;
    private void dump() {
        for (int i = 0; i < 200; i++) {
            new Thread((Runnable) () -> {
                for (int k = 0; k < 50; k++) {
                    base++;
                }
            }).start();
        }
        System.out.println(base);
    }
    public static void main(String[] args) {
        BaseType baseType = new BaseType();
        baseType.dump();
    }
}
