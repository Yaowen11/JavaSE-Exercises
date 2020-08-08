package algorithm;


import java.util.Arrays;

/**
 * @author z
 */
public class CardNumber {
    private static String[] cards = {
            "6253624077546016",
            "4835910111897941",
            "6226890089232192"
    };

    public boolean verifyCard(String card) {
        char[] chars = card.toCharArray();
        int base = chars.length % 2 == 0 ? 1 : 0;
        int cardSum = 0;
        for (int i =0; i < chars.length; i++) {
            var current = Integer.parseInt(String.valueOf(chars[i]));
            var temp = i % 2 == base ? current * 2 > 9 ? current * 2 - 9 : current * 2 : current;
            cardSum += temp;
            System.out.printf("num: %d, temp: %d, sum: %d\n", current, temp, cardSum);
        }
        return cardSum % 10 == 0;
    }

    public static void main(String[] args) {
        CardNumber cardNumber = new CardNumber();
        for (String card : cards) {
            System.out.printf("card %s verify %b\n", card, cardNumber.verifyCard(card));
        }
    }
}
