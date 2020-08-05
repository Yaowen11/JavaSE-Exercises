package algorithm.sort;

/**
 * @author z
 */
public class Quick {

    private final String[] originString = {
            "Intel", "Facebook", "Zillow", "Yahoo", "Pinterest", "Twitter", "Verizon", "Bing",
            "Apple", "Google", "Microsoft", "Sony", "PayPal", "Skype", "IBM", "Ebay"
    };

    private final int[] originInt = {7, 23, 11, 9, 12, 21, 17, 10, 30, 55, 33, 44, 88, 100, 92, 38, 98, 24, 34};

    public void quick(int[] origin, int start, int end) {
        if (start > end) {
            return;
        }
        int p = origin[start];
    }
}
