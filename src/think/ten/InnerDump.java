package think.ten;

/**
 * @author zyw
 * @date 2020/5/25 21:22
 */
public class InnerDump {

    private String string;

    InnerDump(String string) {
        this.string = string;
    }

    class Inner {
        public void dumpString() {
            System.out.print(string + " ");
        }
    }

    Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        int size = 10;
        Sequence sequence = new Sequence(size);
        for (int i = 0; i < size; i++) {
            sequence.add(new InnerDump(String.valueOf(i)));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            ((InnerDump)selector.current()).inner().dumpString();
            selector.next();
        }
    }
}
