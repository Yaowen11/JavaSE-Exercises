package think.eight;

/**
 * @author zyw
 * @date 2020/5/23 11:26
 */
public class Music {
    public static void tune(Instrument instrument) {
        instrument.play(Note.MIDDLE_C);
    }
    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
    }
}
