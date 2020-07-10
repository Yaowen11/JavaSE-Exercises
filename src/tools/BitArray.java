package tools;

/**
 * @author z
 */
public class BitArray {

    boolean getBit(int[] bit, int index) {
        int elementIndex = index / 32;
        System.out.println("element index: " + elementIndex);
        int position = index % 32;
        System.out.println("position: " + position);
        long flag = 1;
        flag = flag << position;
        System.out.println(Long.toHexString(flag));
        System.out.println(bit[elementIndex] & flag);
        return (bit[elementIndex] & flag) != 0;
    }

    void setBit(int[] array, int index) {
        int elementIndex = index / 32;
        int position = index % 32;
        long flag = 1;
        flag = flag << position;
    }
    public static void main(String[] args) {
        BitArray bitArray = new BitArray();
        int[] d = new int[2];
        System.out.println(bitArray.getBit(d,12));
    }
}
