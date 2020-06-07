package think.twelve;

/**
 * @author zyw
 * @date 2020/6/3 20:28
 */
public class OneOfSwitch {
    static private class Switch {
        private boolean state = false;
        public boolean read() { return state; }
        public void on() { state = true; System.out.println(this); }
        private void off() { state = false; System.out.println(this); }

        @Override
        public String toString() {
            return state ? "on" : "off";
        }
    }

    static private class OnOffException extends Exception {}
    static private class OnOffException1 extends Exception {}

    private static Switch aSwitch = new Switch();

    public static void f() throws OnOffException, OnOffException1 {}

    public static void main(String[] args) {
        try {
            aSwitch.on();
            f();
            aSwitch.off();
        } catch (OnOffException e) {
            System.out.println("OnOffException1");
            aSwitch.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException2");
        } finally {
            aSwitch.off();
        }
    }
}


