package think.eighteen.seri;

import java.io.*;

class Blip implements Externalizable {

    public Blip() {
        System.out.println("Blip Constructor");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip.readExternal");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip.writeExternal");
    }

}

class Blip1 implements Externalizable {

    Blip1() {
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1 readExternal");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1 writeExternal");
    }
}

public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blip blip = new Blip();
        Blip1 blip1 = new Blip1();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects");
        objectOutputStream.writeObject(blip);
        objectOutputStream.writeObject(blip1);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering objects");
        var unBlip = (Blip) objectInputStream.readObject();
        var unBlip1 = (Blip1) objectInputStream.readObject();
        System.out.println(blip == unBlip);
        System.out.println(blip1 == unBlip1);


    }
}
