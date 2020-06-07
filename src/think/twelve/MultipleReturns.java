package think.twelve;

/**
 * @author zyw
 * @date 2020/6/3 20:35
 */
public class MultipleReturns {
    public static void f(int f) {
        System.out.println("Initialization that requires cleanup");
        try {
            System.out.println(1);
            if (f == 1) {
                return;
            }
            System.out.println(2);
            if (f == 3) { return; }

        } finally {
            System.out.println("Performing cleanup");
        }
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            f(i);
        }
    }
}
