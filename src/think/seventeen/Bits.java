package think.seventeen;

import java.util.BitSet;
import java.util.Random;

/**
 * @author z
 **/
public class Bits {
    public static void printBitSet(BitSet bitSet) {
        System.out.println("bits: " + bitSet);
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < bitSet.size(); j++) {
            builder.append(bitSet.get(j) ? "1" : "0");
        }
        System.out.println("bit pattern: " + builder.toString());
    }
    public static void main(String[] args) {
        dump(7);
        dump(15);
        dump(31);
    }

    public static void dump(int base) {
        Random random = new Random();
        byte bits = (byte) random.nextInt();
        BitSet bitSet = new BitSet();
        for (int i = base; i >= 0; i--) {
            if (((1 << i) & bits) != 0) {
                bitSet.set(i);
            } else {
                bitSet.clear(i);
            }
        }
        System.out.println("byte value: " + bitSet);
        printBitSet(bitSet);
    }
}
