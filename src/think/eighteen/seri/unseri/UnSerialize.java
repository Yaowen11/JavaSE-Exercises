package think.eighteen.seri.unseri;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class UnSerialize {
    public static void main(String[] args) throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("X.file"));
        Object alien = inputStream.readObject();
        System.out.println(alien.getClass());
    }
}
