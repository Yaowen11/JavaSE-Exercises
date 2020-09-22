package think.eighteen.seri;

import java.io.*;

public class ExternalizableDemo implements Externalizable {

    private int i;

    private String s;

    public ExternalizableDemo() {
        System.out.println("Externalizable demo");
    }

    public ExternalizableDemo(String x, int a) {
        System.out.println("ExternalizableDemo(String x, int a)");
        s = x;
        i = a;
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("ExternalizableDemo.readExternal");
        s = (String) in.readObject();
        i = in.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("ExternalizableDemo.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructor objects:");
        ExternalizableDemo externalizableDemo = new ExternalizableDemo("A String", 48);
        System.out.println(externalizableDemo);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("externalizable.out"));
        System.out.println("Saving object:");
        objectOutputStream.writeObject(externalizableDemo);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("externalizable.out"));
        System.out.println("recovering object:");
        var re = (ExternalizableDemo) objectInputStream.readObject();
        System.out.println(re);
    }
}
