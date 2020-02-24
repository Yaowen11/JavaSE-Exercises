package se.enums;

import se.tools.Enums;

enum Activity {SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING}
/**
 * @author zhangyaowen
 */
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(Enums.random(Activity.class) + " ");
        }
    }
}
