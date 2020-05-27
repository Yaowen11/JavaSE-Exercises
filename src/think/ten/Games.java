package think.ten;

/**
 * @author z
 * @date 2020/5/27 13:43
 */
public class Games {
    public static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        while (s.move()) {

        }
    }
    public static void main(String[] args) {
        playGame(Chess.factory);
        playGame(Checkers.factory);
    }
}

interface Game { boolean move(); }
interface GameFactory { Game getGame(); }

class Checkers implements Game {
    private Checkers() {}
    private int moves = 0;
    private static final int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }

    public static GameFactory factory = Checkers::new;
}

class Chess implements Game {
    private Chess(){}
    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
    public static GameFactory factory = Chess::new;
}