package se.base;

/**
 * @author zhangyaowen
 */
public class StringInfo {

    public static void main(String[] args) {
        System.out.println(String.join(" / ", "S", "M", "L", "XL"));
        stringCodePoint();
    }


    private static void stringCodePoint()
    {
        BaseClass baseClass = new BaseClass();
        System.out.println(baseClass.getSale());
        System.out.println(baseClass.getDesc());
        String baseCodePoint = "hello world";
        String multiCodePoint = "😊🐍🐸";
        System.out.println("base code unit count: " + baseCodePoint.length());
        System.out.println("base code point count: " + baseCodePoint.codePointCount(0, baseCodePoint.length()));
        System.out.println("multi code unit count: " + multiCodePoint.length());
        System.out.println("multi code point count: " + multiCodePoint.codePointCount(0, multiCodePoint.length()));
        System.out.println("first code unit char: " + multiCodePoint.charAt(1));
        System.out.println("first code point: " + multiCodePoint.offsetByCodePoints(0, 1));
        System.out.println("middle char: " +  baseCodePoint.charAt(2));
        System.out.println("last char: " + baseCodePoint.charAt(3));
        int[] codePoints = multiCodePoint.codePoints().toArray();
        for (int i :codePoints) {
            System.out.print(i + " ");
        }
        System.out.println(new String(codePoints, 0, codePoints.length));
    }
}
