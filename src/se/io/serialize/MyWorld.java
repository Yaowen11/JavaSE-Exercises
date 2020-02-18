package se.io.serialize;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

class House implements Serializable {}
class Animal implements Serializable {
    private String name;
    private House preferredHouse;
    Animal (String nm, House mouse) {
        name = nm;
        preferredHouse = mouse;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", preferredHouse=" + preferredHouse +
                '}';
    }
}

/**
 * @author z
 */
public class MyWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House mouse = new House();
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("Bosco the dog", mouse));
        animalList.add(new Animal("Ralph the hamster", mouse));
        animalList.add(new Animal("Molly the cat", mouse));
        System.out.println("animalList: " + animalList);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(animalList);
        objectOutputStream.writeObject(animalList);
        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(byteArrayOutputStream1);
        objectOutputStream1.writeObject(animalList);
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream1.toByteArray()));
        List<Animal> animalList1 = (List<Animal>) inputStream.readObject();
        List<Animal> animalList2 = (List<Animal>) inputStream.readObject();
        List<Animal> animalList3 = (List<Animal>) in2.readObject();
        animalList1.forEach(System.out::println);
        animalList2.forEach(System.out::println);
        animalList3.forEach(System.out::println);
    }
}
