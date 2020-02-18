package se.io.serialize;

import java.io.*;

/**
 * @author z
 */
public class Blip implements Externalizable {

    private int i;

    private String s;

    public Blip() {
        System.out.println("Blip constructor");
    }

    public Blip(String s, int i) {
        System.out.println("Blip (String int)");
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        System.out.println("Blip writeExternal");
        objectOutput.writeObject(s);
        objectOutput.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        System.out.println("Blip readExternal");
        s = (String) objectInput.readObject();
        i = objectInput.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing Objects: ");
        Blip blip = new Blip("A String ", 47);
        System.out.println(blip);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Blip.out"));
        System.out.println("Saving Object: ");
        objectOutputStream.writeObject(blip);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Blip.out"));
        System.out.println("Recovering Blip: ");
        Blip blip1 = (Blip) objectInputStream.readObject();
        System.out.println(blip1);
    }
}
