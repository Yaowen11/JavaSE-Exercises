package think.fifteen.genericfunction;

/**
 * @author zyw
 * @date 2020/8/22 21:05
 */
public class SimpleHolder {
    private Object object;
    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("Item");
        String s = (String) holder.get();
    }
}
