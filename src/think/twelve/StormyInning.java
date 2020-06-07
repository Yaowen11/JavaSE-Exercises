package think.twelve;

/**
 * @author zyw
 * @date 2020/6/3 20:42
 */
public class StormyInning {
    public StormyInning() throws RaineOut,BaseballException{}
    public StormyInning(String s) throws Foul, BaseballException {}
    public void rainHard() throws RaineOut {}
    public void event() {}
    public static void main(String[] args) {
        try {
            StormyInning stormyInning = new StormyInning();
            stormyInning.event();
        } catch (PopFoul e) {

        } catch (RaineOut ignored) {

        } catch (BaseballException e) {

        }
    }
}

class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}
abstract class Inning {
    public Inning() throws BaseballException {

    }

    public void event() throws BaseballException {

    }
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends Exception {}
class RaineOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RaineOut;
    public void rainHard() throws RaineOut;
}
