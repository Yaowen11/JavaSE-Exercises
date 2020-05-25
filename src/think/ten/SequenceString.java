package think.ten;

/**
 * @author zyw
 * @date 2020/5/25 21:13
 */
public class SequenceString {

    private String string;

    SequenceString(String string) {
        this.string = string;
    }

    public void dumpString() {
        System.out.print(string + " ");
    }

    public static void main(String[] args) {
        int size = 10;
        Sequence sequence = new Sequence(size);
        for (int i = 0; i < size; i++) {
            sequence.add(new SequenceString(String.valueOf(i)));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            ((SequenceString) selector.current()).dumpString();
            selector.next();
        }
    }
}
