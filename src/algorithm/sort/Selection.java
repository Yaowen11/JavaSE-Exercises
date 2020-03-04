package algorithm.sort;

/**
 * select
 * @author zhangyaowen
 */
public class Selection implements Sort {
    @Override
    public <T extends Comparable<T>> void sort(T[] origin, ORDER order) {
        if (origin.length < SORT_SIZE) {
            return;
        }
        for (int i = 0; i < origin.length; i++) {
            int selectIndex = i;
            for (int l = i + 1; l < origin.length; l++) {
                int compared = origin[l].compareTo(origin[selectIndex]);
                if (order == ORDER.DESC) {
                    if (compared > 0) {
                        selectIndex = l;
                    }
                }
                if (order == ORDER.ASC) {
                    if (compared < 0) {
                        selectIndex = l;
                    }
                }
            }
            T temp = origin[i];
            origin[i] = origin[selectIndex];
            origin[selectIndex] = temp;
        }
    }
    public static void main(String[] args) {
        Selection selection = new Selection();
        selection.dump();
    }
}
