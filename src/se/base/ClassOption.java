package se.base;

import jdbc.mysql.CityCurd;

class ClassOption extends BaseClass {

    protected Integer size;

    ClassOption(int size) {
        super(size);
    }

    public void addSize(int size) {
        if (getSize() != size) {
            this.size = size;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassOption.class.getClassLoader();
        loader.loadClass("se.base.StaticLoad");
    }
}
