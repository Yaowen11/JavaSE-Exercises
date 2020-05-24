package think.eight;

/**
 * @author zyw
 * @date 2020/5/23 11:22
 */
public class Wind extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Wind.play() " + note);
    }
}