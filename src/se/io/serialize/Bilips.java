package se.io.serialize;

import java.io.*;
import java.util.Objects;

class Bilp1 implements Externalizable {
    public Bilp1() {
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Bilp2 implements Externalizable {
    Bilp2() {
        System.out.println("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}

/**
 * @author z
 */
public class Bilips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Bilp1 bilp1 = new Bilp1();
        Bilp2 bilp2 = new Bilp2();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects: ");
        objectOutputStream.writeObject(bilp1);
        objectOutputStream.writeObject(bilp2);
        objectOutputStream.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1: ");
        Bilp1 b1 = (Bilp1) in.readObject();
        System.out.println("b1 == bilp1 " + (b1.equals(bilp1)));
        Bilp2 b2 = (Bilp2) in.readObject();
        System.out.println("b2 == bilp2 " + (b2.equals(bilp2)));
    }
}
