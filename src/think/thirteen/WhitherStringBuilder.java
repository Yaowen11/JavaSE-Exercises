package think.thirteen;

import java.util.Random;

/**
 * @author zyw
 * @date 2020/6/7 19:39
 */
public class WhitherStringBuilder {
    public String implicit(String[] fields) {
        String result = "";
        for (int i = 0; i < fields.length; i++) {
            result += fields[i];
        }
        return result;
    }
    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            result.append(fields[i]);
        }
        return result.toString();
    }

    public String usStringBuilder() {
        final Random random = new Random(47);
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(random.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        WhitherStringBuilder whitherStringBuilder = new WhitherStringBuilder();
        System.out.println(
                whitherStringBuilder.usStringBuilder());
    }
}
