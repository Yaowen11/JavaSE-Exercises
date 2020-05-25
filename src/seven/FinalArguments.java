package seven;

import vm.gc.FinalizeEscapeGc;

class Gizmo {
    public void spin() {}
}

public class FinalArguments {
    void with(final Gizmo g) {
        g.spin();
    }
    void withOut(Gizmo g) {
        g = new Gizmo();
        g.spin();
    }
    int g(final int i) {
        return  i + 1;
    }
    public static void main(String[] args) {
        FinalArguments finalArguments = new FinalArguments();
        finalArguments.with(null);
        finalArguments.withOut(null);
    }
}
