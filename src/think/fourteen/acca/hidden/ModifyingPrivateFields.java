package think.fourteen.acca.hidden;

/**
 * @author zyw
 * @date 2020/8/3 21:30
 */
public class ModifyingPrivateFields {
    public static void main(String[] args) throws Exception {
        WithPrivateFinalField withPrivateFinalField = new WithPrivateFinalField();
        System.out.println(withPrivateFinalField);
        var f = withPrivateFinalField.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println("f.getInt(withPrivateFinalField): " + f.getInt(withPrivateFinalField));
        f.setInt(withPrivateFinalField, 47);
        System.out.println(withPrivateFinalField);
        f = withPrivateFinalField.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("f.get(withPrivateFinalField): " + f.get(withPrivateFinalField));
        f.set(withPrivateFinalField, "No, you're not!");
        System.out.println(withPrivateFinalField);
        f = withPrivateFinalField.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        System.out.println("f.get(withPrivateField): " + f.get(withPrivateFinalField));
        f.set(withPrivateFinalField, "No, you're not");
        System.out.println(withPrivateFinalField);
    }
}
