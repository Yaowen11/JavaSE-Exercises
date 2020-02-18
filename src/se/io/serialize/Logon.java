package se.io.serialize;

import java.io.*;
import java.util.Date;

/**
 * @author z
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;
    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Logon a = new Logon("Hulk", "secret");
        System.out.println("a = " + a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println("Recovering object at " + new Date());
        a = (Logon) objectInputStream.readObject();
        System.out.println("logon a = " + a);
    }
}
