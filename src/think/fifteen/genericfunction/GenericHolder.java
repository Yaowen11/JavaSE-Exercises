package think.fifteen.genericfunction;

/**
 * @author zyw
 * @date 2020/8/22 21:16
 */
public class GenericHolder<T> {
    private T obj;
    public void set(T obj) { this.obj = obj; }
    public T get() { return obj; }
    public static void main(String[] args) {
        GenericHolder<String> stringGenericHolder = new GenericHolder<>();
        stringGenericHolder.set("Item");
        String s = stringGenericHolder.get();
    }
}
