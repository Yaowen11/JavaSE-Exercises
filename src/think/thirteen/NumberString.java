package think.thirteen;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class NumberString {
    public static void main(String[] args) throws Exception {
        String num = "556026.0";
        if (".0".equals(num.substring(num.length() - 2, num.length()))) {
            System.out.println(num.substring(0, num.length() - 2));
        }
        dump();

    }

    static void dump() throws Exception {
        String origin = "insert into erp_all_user values ('Ӣ','510124197404094620','HN','ɶһ','','','HN05','һװ2','1','-Ĥ','60','H','00006038','6','2012-04-19')";
        String gbk = new String(origin.getBytes("GBK"), "ISO-8859-1");
        String utf8 = new String(gbk.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(gbk);
        System.out.println(utf8);

        String chinese = "中文";//java内部编码
        String gbkChinese = new String(chinese.getBytes("GBK"),"ISO-8859-1");//转换成gbk编码
        System.out.println(gbkChinese);
		String unicodeChinese = new String(gbkChinese.getBytes("ISO-8859-1"),"GBK");//java内部编码
		System.out.println(unicodeChinese);//中文
		String utf8Chinese = new String(unicodeChinese.getBytes("UTF-8"),"ISO-8859-1");//utf--8编码
		System.out.println(utf8Chinese);//乱码
		unicodeChinese = new String(utf8Chinese.getBytes("ISO-8859-1"),"UTF-8");//java内部编码
		System.out.println(unicodeChinese);//中文
    }
}