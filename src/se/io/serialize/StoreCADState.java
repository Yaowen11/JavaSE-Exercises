package se.io.serialize;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author z
 */
abstract class Shape implements Serializable {
    public static final int RED = 1;
    public static final int BLUE = 2;
    public static final int GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;

    /**
     * set color
     * @param newColor
     */
    public abstract void setColor(int newColor);

    /**
     * color int
     * @return int
     */
    public abstract int getColor();
    public Shape(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return getClass() + " color[" + getColor() + "] xPos[" + xPos +
                "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static Shape randomFactory() {
        int xPos = rand.nextInt(100);
        int yPos = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0: return new Circle(xPos, yPos, dim);
            case 1: return new Square(xPos, yPos, dim);
            case 2: return new Line(xPos, yPos, dim);
        }
    }
}

class Circle extends Shape {
    private static int color = RED;
    public Circle(int x, int y, int d) {
        super(x, y, d);
    }

    @Override
    public void setColor(int color) {
        Circle.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Square extends Shape {
    private static int color;
    public Square(int x, int y, int z) {
        super(x, y, z);
    }

    @Override
    public void setColor(int color) {
        Square.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Line extends Shape {

    private static int color = RED;

    public static void serializedStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public Line(int x, int y, int z) {
        super(x, y, z);
    }

    @Override
    public void setColor(int color) {
        Line.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}

/**
 * @author z
 */
public class StoreCADState {

    public static void main(String[] args) throws Exception {
        recoveringSerializableState();
    }

    private static void serializableStatic() throws IOException {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);
        List<Shape> shapes = new ArrayList<>();
        int init = 10;
        for (int i = 0; i < init; i++) {
            shapes.add(Shape.randomFactory());
        }
        for (int i = 0; i < init; i++) {
            shapes.get(i).setColor(Shape.GREEN);
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        out.writeObject(shapeTypes);
        Line.serializedStaticState(out);
        out.writeObject(shapes);
        System.out.println(shapes);
    }

    @SuppressWarnings("unchecked")
    private static void recoveringSerializableState() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        List<Class<? extends Shape>>  shapeTypes = (List<Class<? extends Shape>>) in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }
}