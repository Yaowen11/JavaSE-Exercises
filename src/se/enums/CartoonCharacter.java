package se.enums;

import se.generic.generation.Generator;

import java.util.Random;

/**
 * @author zhangyaowen
 */
public enum CartoonCharacter implements Generator<CartoonCharacter> {
    /**
     * sip
     */
    SLAPPY,
    /**
     * spa
     */
    SPANKY,
    /**
     * punchy
     */
    PUNCHY,
    /**
     * silly
     */
    SILLY,
    /**
     * bouncy
     */
    BOUNCY,
    /**
     * nutty
     */
    NUTTY,
    /**
     * bob
     */
    BOB;
    private Random rand = new Random(47);
    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(CartoonCharacter.BOB.next());
        }
    }
}
