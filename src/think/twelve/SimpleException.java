package think.twelve;

/**
 * @author zyw
 * @date 2020/6/2 21:00
 */
public class SimpleException extends Exception {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }
    public static void main(String[] args) {
        SimpleException simpleException = new SimpleException();
        try {
            simpleException.f();
        } catch (SimpleException e) {
            e.printStackTrace();
            System.out.println("Caught it!");
        }
    }
}
