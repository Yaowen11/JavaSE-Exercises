package think.nine;

/**
 * @author z
 * @date 2020/5/25 16:32
 */
public class Games {
    public static void playGame(GameFactory factory) {
        Game game = factory.getGame();
        while (game.move()) {
            ;
        }
    }
    public static void main(String[] args) {
        playGame(new ChecksFactory());
        playGame(new ChessFactory());
    }
}

interface Game {
    boolean move();
}

interface GameFactory { Game getGame(); }

class Checkers implements Game {
    private int moves = 0;
    private static final int MOVES = 3;
    @Override public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

class ChecksFactory implements GameFactory {
    @Override public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game {
    private int moves = 0;
    private static final int MOVES = 4;
    @Override public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
}

class ChessFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Chess();
    }
}