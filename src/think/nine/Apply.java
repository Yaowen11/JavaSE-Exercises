package think.nine;

import java.util.Arrays;

/**
 * @author zyw
 * @date 2020/5/24 20:33
 */
public class Apply {
    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static String s = "Disagreement with beliefs is by definition incorrect";
}

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }
    Object process(Object in) {
        return in;
    }
}

class Upcase extends Processor {
    @Override String process(Object in) {
        return ((String) in).toUpperCase();
    }
}

class Downcase extends Processor {
    @Override String process(Object in) {
        return ((String)in).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override String process(Object in) {
        return Arrays.toString(((String) in).split(" "));
    }
}


