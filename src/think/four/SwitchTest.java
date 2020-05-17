package think.four;

/**
 * @author zyw
 */
public class SwitchTest {
    public static void main(String[] args) {
        long mod = (System.currentTimeMillis() % 7);
        String args1 = "a";
        switch (args1) {
            case "a":
                System.out.println("1");
                break;
            case "b":
                System.out.println("2");
                break;
            case "c":
                System.out.println("3");
                break;
            default:
                System.out.println("4");
                break;
        }
    }
}
