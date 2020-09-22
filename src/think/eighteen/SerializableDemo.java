package think.eighteen;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @author z
 **/
public class SerializableDemo implements Serializable {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        SerializableDemo serializableDemo = new SerializableDemo(6, 'a');
        System.out.println("origin serializable: " + serializableDemo);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
        out.writeObject("Worm storage\n");
        out.writeObject(serializableDemo);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
        String s = (String) in.readObject();
        System.out.println("un serialize string: " + s);
        SerializableDemo serializableDemo1 = (SerializableDemo) in.readObject();
        System.out.println("serializable: " + serializableDemo1);
    }

    private static final Random random = new Random(47);

    private final Data[] d = {
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