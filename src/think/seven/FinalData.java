package think.seven;

import java.util.Random;

class Value {
    int i;
    public Value(int i) {this.i = i;};
}

public class FinalData {

    private static Random random = new Random();

    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    private final int valueOne = 9;

    private static final int VALUE_THREE = 30;

    private final int i4 = random.nextInt();

    static final int INT_5 = random.nextInt();

    private Value v1 = new Value(11);

    private final Value v2 = new Value(22);

    private static final Value VAL_3 = new Value(33);

    private final int[] a = {1, 2, 3, 4, 5, 6};

    @Override public String toString() {
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }

    public static void main(String[] args) {
        FinalData finalData = new FinalData("fd1");
        finalData.v2.i++;
        finalData.v1 = new Value(9);
        for (int i = 0; i < finalData.a.length; i++) {
            finalData.a[i]++;
        }
        System.out.println(finalData);
        System.out.println("Creating new FinalData");
        FinalData finalData1 = new FinalData("fd2");
        System.out.println(finalData);
        System.out.println(finalData1);
    }

}
