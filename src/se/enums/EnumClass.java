package se.enums;

/**
 * @author zhangyaowen
 */
public class EnumClass {
    enum Shrubbery {GROUND, CRAWLING, HANGING}
    public static void main(String[] args) {
        for (Shrubbery shrubbery: Shrubbery.values()) {
            System.out.println(shrubbery + " ordinal: " + shrubbery.ordinal());
            System.out.println(shrubbery.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.println(shrubbery.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(shrubbery.getDeclaringClass());
            System.out.println(shrubbery.name());
            System.out.println("---------");
        }
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shr = Enum.valueOf(Shrubbery.class, s);
            System.out.println(Shrubbery.valueOf(shr.name()));
        }
    }
}
