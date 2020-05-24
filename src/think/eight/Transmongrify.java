package think.eight;

/**
 * @author zyw
 * @date 2020/5/23 20:59
 */
public class Transmongrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}

class Actor {
    public void act() {

    }
}

class HappyActor extends Actor {
    @Override public void act() {
        System.out.println("happyActor");
    }
}

class SadActor extends Actor {
    @Override public void act() {
        System.out.println("SadActor");
    }
}

class Stage {
    private Actor actor = new HappyActor();
    public void change() {
        actor = new SadActor();
    }
    public void performPlay() {
        actor.act();
    }
}

