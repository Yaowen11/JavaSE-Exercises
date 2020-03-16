package tools;

/**
 * @author z
 */
public class IpTransferString {

    private static final int IPV4_SPLIT_LENGTH = 4;

    private static final String IP_SPLIT = "\\.";

    public static int ipv42Int(String ip) {

        String[] split = ip.split(IP_SPLIT);

        return ((Integer.parseInt(split[0]) << 24) + (Integer.parseInt(split[1]) << 16)
                + (Integer.parseInt(split[2]) << 8) + (Integer.parseInt(split[3])));
    }

    public static String int2Ipv4(Integer ipInt) {
        return (ipInt >>> 24) +
                "." +
                ((ipInt & 0x00FFFFFF) >>> 16) +
                "." +
                ((ipInt & 0x0000FFFF) >>> 8) +
                "." +
                (ipInt & 0x000000FF);
    }
}
