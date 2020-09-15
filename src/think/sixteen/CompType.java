package think.sixteen;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author z
 **/
public class CompType implements Comparable<CompType> {
    private final int i;
    CompType(int i) {
        this.i = i;
    }
    @Override
    public int compareTo(CompType o) {
        return Integer.compare(i, o.i);
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }

    public void dump() {
        CompType[] compTypes = {new CompType(56), new CompType(23), new CompType(32), new CompType(45)};
        Arrays.sort(compTypes, Collections.reverseOrder());
        System.out.println(Arrays.toString(compTypes));
        Arrays.sort(compTypes);
        System.out.println(Arrays.toString(compTypes));
    }

    public static void main(String[] args) {
        int[] ints = {2, 45, 192, 223, 221, 292, 308, 444, 142, 212, 87};
        Arrays.sort(ints);
        System.out.println(Arrays.binarySearch(ints, 2590));
    }
}
