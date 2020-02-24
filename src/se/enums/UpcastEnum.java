package se.enums;

enum Search {HITHER, YON}
/**
 * @author zhangyaowen
 */
public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER;
        for (Enum en: e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
        Class<Integer> integerClass = Integer.class;
        try {
            for (Object en: integerClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
