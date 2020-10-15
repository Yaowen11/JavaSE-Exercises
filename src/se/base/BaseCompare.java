package se.base;

import java.util.Objects;

public class BaseCompare {
    public static void main(String[] args) {
        BaseCompare baseCompare = new BaseCompare();
        baseCompare.useEqual();
    }

    public void useEqual() {
       float a = 0.9f;
       float b = 0.9f;
       if (a == b) {
           System.out.println("a == b is true");
       }
       Float x = 0.9f;
       Float y = 0.9f;
       if (x.equals(y)) {
           System.out.println("x.equals(y) is true");
       }
    }
}
