package se.secrity;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import se.base.BaseClass;

/**
 * @author zhangyaowen
 */
public class StringHash extends BaseClass {

    StringHash() {
        super();
    }

    public void change() {
        this.getSale();
    }

    public static void main(String[] args) {
        String md5Hash123456 = "e10adc3949ba59abbe56e057f20f883e";
        String algorithm = "MD5";
        String origin = "123456";
        try {
            if (md5Hash123456.equals(dumpStringHash(origin.getBytes(StandardCharsets.UTF_8), algorithm))) {
                System.out.println("hash right");
            }
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private static String dumpStringHash(byte[] origin, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        byte[] hashString = messageDigest.digest(origin);
        StringBuilder hBuilder = new StringBuilder("");
        int n;
        for (byte b : hashString) {
            n = b;
            if (n < 0) {
                n += 256;
            }
            if (n < 16) {
                hBuilder.append("0");
            }
            hBuilder.append(Integer.toHexString(n));
        }
        return hBuilder.toString();
    }
}
