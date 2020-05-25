package think.nine;

import java.util.Random;

/**
 * @author z
 * @date 2020/5/25 17:07
 */
public class Farme {
    public static void service(PushGameFactory pushGameFactory) {
        System.out.println(pushGameFactory.getPushGame().dropCoin());
        System.out.println(pushGameFactory.getPushGame().dropDice());
    }
    public static void main(String[] args) {
        service(new PushGameFactoryImpl());
    }
}

interface PushGame {
    boolean dropCoin();
    int dropDice();
}

interface PushGameFactory {
    PushGame getPushGame();
}

class PushGameImpl implements PushGame {

    private final Random random = new Random();

    @Override
    public boolean dropCoin() {
        if (System.currentTimeMillis() % 2 == 1) {
            return false;
        }
        return true;
    }

    @Override
    public int dropDice() {
        return random.nextInt(6);
    }
}

class PushGameFactoryImpl implements PushGameFactory {
    @Override
    public PushGame getPushGame() {
        return new PushGameImpl();
    }
}