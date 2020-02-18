package se.io.serialize;

import java.io.Serializable;

/**
 * @author z
 */
public class Data implements Serializable {
    private int n;
    public Data(int n) { this.n = n; }
    @Override
    public String toString() {
        return Integer.toString(n);
    }

}
