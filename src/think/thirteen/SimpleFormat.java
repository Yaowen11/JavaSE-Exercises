package think.thirteen;

import se.io.oio.BinaryFile;

import java.io.File;
import java.io.PrintStream;
import java.util.Formatter;

/**
 * @author zyw
 * @date 2020/6/7 20:24
 */
public class SimpleFormat {

    static class Turtle {
        private String name;
        private Formatter formatter;
        Turtle(String name, Formatter formatter) {
            this.name = name;
            this.formatter = formatter;
        }
        public void move(int x, int y) {
            formatter.format("%s The Turtle is at (%d, %d)\n", name, x, y);
        }
        public static void dump() {
            PrintStream printStream = System.out;
            Turtle tommy = new Turtle("Tommy", new Formatter(System.err));
            Turtle terry = new Turtle("Terry", new Formatter(printStream));
            tommy.move(0, 0);
            terry.move(4, 8);
            tommy.move(3, 4);
            terry.move(2, 5);
            tommy.move(3, 3);
            terry.move(3, 3);
        }
    }

    static class Receipt {
        private double total = 0;
        private Formatter formatter = new Formatter(System.out);
        public void printTitle() {
            formatter.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
            formatter.format("%-15s %5s %10s\n", "----", "---", "-----");
        }
        public void print(String name, int qty, double price) {
            formatter.format("%-15.15s %5d %10.2f\n", name, qty, price);
            total += price;
        }
        public void printTotal() {
            formatter.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
            formatter.format("%-15s %5s %10s\n", "", "", "-----");
            formatter.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
        }
        public static void dump() {
            Receipt receipt = new Receipt();
            receipt.printTitle();;
            receipt.print("Jack's Magic Beans", 4, 4.25);
            receipt.print("Princess Peas", 3, 5.1);
            receipt.print("Three Bears Porridge", 1, 14.29);
            receipt.printTotal();
        }
    }

    static class DatabaseException extends Exception {
        DatabaseException(int transactionId, int queryId, String message) {
            super(String.format("(t%d, q%d) %s", transactionId, queryId, message));
        }
        public static void dump() {
            try {
                throw new DatabaseException(3, 7, "Write failed");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static class Hex {
        public static String format(byte[] data) {
            StringBuilder result = new StringBuilder();
            int n = 0;
            for (byte b: data) {
                if (n % 16 == 0) {
                    result.append(String.format("%05x: ", n));
                }
                result.append(String.format("%02x ", b));
                n++;
                if (n % 16 == 0) {
                    result.append("\n");
                }
            }
            result.append("\n");
            return result.toString();
        }
        public static void dump(String[] args) throws Exception {
            if (args.length == 0) {
                System.out.println(format(BinaryFile.read("Hex.class")));
            } else {
                System.out.println(format(BinaryFile.read(new File(args[0]))));
            }
        }
    }
    public static void main(String[] args) {
        int x = 5;
        double y = 5.332542;
        System.out.println("Row 1: [" + x + " " + y + "]");
        System.out.format("Row 1: [%d %f]\n", x, y);
        System.out.printf("Row 1: [%d %f]\n", x, y);
        Turtle.dump();
        Receipt.dump();
        DatabaseException.dump();
        try {
            Hex.dump(new String[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
