package algorithm.sort;

/**
 * @author zhangyaowen
 */
public class Insertion implements Sort {
    @Override
    public <T extends Comparable<T>> void sort(T[] origin, ORDER order) {
        if (origin.length < SORT_SIZE) {
            return;
        }
        for (int i = 1; i < origin.length; i++) {
            T temp = origin[i];
            int l = i - 1;
            for (; l >= 0; l--) {
                int compare = temp.compareTo(origin[l]);
                if (order == ORDER.DESC) {
                    if (compare < 0) {
                        origin[l + 1] = origin[l];
                    } else {
                        break;
                    }
                } else {
                    if (compare > 0) {
                        origin[l + 1] = origin[l];
                    } else {
                        break;
                    }
                }
            }
            origin[l + 1] = temp;
        }
    }
    public static void main(String[] args) {
        Insertion insert = new Insertion();
        insert.dump();
    }
}
