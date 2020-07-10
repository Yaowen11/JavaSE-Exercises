package think.two;

public class Temp {
    public static void main(String[] args) {
        System.out.println(13 & 17);
        int[] bitArray = {0, 1};
        Temp temp = new Temp();
        System.out.println(temp.getBit(bitArray, 32));
    }
    

    boolean getBit(int[] array, int index) {
        int elementIndex = index / 32;
        int position = index % 32;
        long flag = 1;
        flag = flag << position;
        if ((array[elementIndex] & flag) != 0) {
            return true;
        }
        return false;
    }
}