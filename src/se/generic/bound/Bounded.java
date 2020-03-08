package se.generic.bound;

import java.awt.*;

class Bounded extends Dimension implements HasColor, Weight {
    @Override
    public int weight() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
