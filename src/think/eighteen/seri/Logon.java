package think.eighteen.seri;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;
    public Logon(String name, String password) {
        username = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println("logon a = " + a);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        objectOutputStream.writeObject(a);
        objectOutputStream.close();
        TimeUnit.SECONDS.sleep(1);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println("Recovering object at " + new Date());
        a = (Logon) objectInputStream.readObject();
        System.out.println("logon a = " + a);
    }
}
