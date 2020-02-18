package se.io.serialize;

import java.io.*;
import java.util.Random;

/**
 * @author z
 */
public class Worm implements Serializable {
    private static Random random = new Random(47);
    private Data[] d = {
        new Data(random.nextInt(10)),
        new Data(random.nextInt(10)),
        new Data(random.nextInt(10))
    };
    private Worm next;
    private char c;
    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + 1);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char) (x + 1));
        }
    }
    public Worm() {
        System.out.println("Default constructor");
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data dat: d) {
            result.append(dat);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Worm w = new Worm(6, 'a');
        System.out.println("w = " + w);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
        String s = (String) in.readObject();
        Worm w2 = (Worm) in.readObject();
        System.out.println("w3 == w: " + w2.equals(w));
        System.out.println("w2 to String: " + w2.toString());
        System.out.println(s + " w2 = " + w2);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        Worm w3 = (Worm) in2.readObject();
        System.out.println("w3 == w: " + w3.equals(w));
        System.out.println("w3 to String: " + w3.toString());
        System.out.println(s + "w3 = " + w3);
    }
}
