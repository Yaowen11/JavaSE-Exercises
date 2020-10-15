package se.base;

public class ChangBit {
    public static void main(String[] args) {
        ChangBit changBit = new ChangBit();
        changBit.leftChangeBit();
        changBit.rightChangeBit();
    }

    public void leftChangeBit() {
        int i = 2048;
        System.out.println(i << 4);
    }

    public void rightChangeBit() {
        int i = 2048;
        System.out.println(i >> 4);
    }
}
