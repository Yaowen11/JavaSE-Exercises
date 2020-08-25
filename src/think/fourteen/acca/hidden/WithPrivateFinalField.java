package think.fourteen.acca.hidden;

/**
 * @author zyw
 * @date 2020/8/3 21:25
 */
public class WithPrivateFinalField {
    private int i = 1;
    private final String s = "I'm totally safe";
    private String s2 = "Am I safe?";

    @Override
    public String toString() {
        return "WithPrivateFinalField{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", s2='" + s2 + '\'' +
                '}';
    }
}
