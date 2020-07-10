package think.fourteen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyw
 * @date 2020/6/16 20:31
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private final Class<?> bastType;
    public TypeCounter(Class<?> bastType) {
        this.bastType = bastType;
    }
    public void count(Object object) {
        Class<?> type = object.getClass();
        if (!bastType.isAssignableFrom(type)) {
            throw new RuntimeException(object + " incorrect type:" + type + ", should be type or subtype of " + bastType);
        }
        countClass(type);
    }
    private void countClass(Class<?> bastType) {
        Integer quantity = get(bastType);
        put(bastType, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = bastType.getSuperclass();
        if (superClass != null && bastType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
            stringBuilder.append(pair.getKey().getSimpleName())
                    .append("=")
                    .append(pair.getValue())
                    .append(". ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
