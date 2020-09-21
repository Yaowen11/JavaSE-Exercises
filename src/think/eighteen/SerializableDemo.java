package think.eighteen;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

/**
 * @author z
 **/
public class SerializableDemo implements Serializable {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        SerializableDemo serializableDemo = new SerializableDemo(6, 'a');
        System.out.println("w + " + serializableDemo);
        OutputStream out;
        ObjectOutputStream out = new ObjectOutputStream(out);
    }

    private static Random random = new Random(47);

    private Data[] d = {
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
    };
    private SerializableDemo next;
    private char c;
    public SerializableDemo(int i, char x) {
        c = x;
        if (--i > 0) {
            next = new SerializableDemo(i, (char)(x + 1));
        }
    }
    public SerializableDemo() {}

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c).append("(");
        for (Data data : d) {
            stringBuilder.append(data);
        }
        stringBuilder.append(")");
        if (next != null) {
            stringBuilder.append(next);
        }
        return stringBuilder.toString();
    }
}

class Data implements Serializable {
    private int n;
    public Data(int n) { this.n = n; }
    @Override
    public String toString() { return Integer.toString(n); }
}