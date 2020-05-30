package think.eleven;

/**
 * @author z
 * @date 2020/5/28 16:59
 */
public interface Fruit extends Comparable<Fruit> {
    /**
     * 味道
     * @return s
     */
    Taste taste();

    static enum  Taste {
        /**
         * sweet
         */
        SWEET,
        /**
         * sweet more acid
         */
        SWEET_AND_ACID,
        /**
         * acid
         */
        ACID,
        /**
         * acid more sweet
         */
        ACID_AND_SWEET;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}
