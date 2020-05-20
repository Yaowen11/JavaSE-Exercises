package think.seven;
interface Base {
    void base();
}

class Extend implements Base {

    @Override
    public void base() {

    }
}
class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }
    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse {}

class Bart extends Homer {
    void doh(Milhouse milhouse) {
        System.out.println("doh(house)");
    }
}

class Lisa extends Homer {
    void doh(Milhouse e) {
        System.out.println("doh(mih)");
    }
}
public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.9f);
        b.doh(new Milhouse());
    }
}
