package algorithm.sort;

/**
 * @author zhangyaowen
 */
public class Bubble implements Sort {

    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        bubble.dump();
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] origin, ORDER order) {
        if (origin.length < SORT_SIZE) {
            return;
        }
        for (int i = 0; i < origin.length; i++) {
            boolean isSorted = true;
            for (int l = i + 1; l < origin.length; l++) {
                int compareResult = origin[i].compareTo(origin[l]);
                if (order == ORDER.DESC) {
                    if (compareResult < 0) {
                        T temp = origin[i];
                        origin[i] = origin[l];
                        origin[l] = temp;
                        isSorted = false;
                    }
                } else {
                    if (compareResult > 0) {
                        T temp = origin[i];
                        origin[i] = origin[l];
                        origin[l] = temp;
                        isSorted = false;
                    }
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
