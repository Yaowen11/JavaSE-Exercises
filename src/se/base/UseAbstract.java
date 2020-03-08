package se.base;

/**
 * @author z
 */
abstract class UseAbstract {

    /**
     * dump
     */
    abstract void dum();

    public static UseAbstract value() {
        return new UseAbstract() {
            @Override
            void dum() {
                System.out.println("the class " + getClass() + " simple ");
            }
        };
    }

    public static void main(String[] args) {
        UseAbstract useAbstract = UseAbstract.value();
        useAbstract.dum();
    }
}
