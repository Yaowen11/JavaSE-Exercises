package se.enums;

/**
 * 在接口的内部，创建实现该接口的枚举，以此将元素进行分组
 * @author zhangyaowen
 */
public interface Food {
    /**
     * @apiNote
     */
    enum Appetizer implements Food {
        /**
         * 沙拉
         */
        SALAD,
        /**
         * 汤
         */
        SOUP,
        /**
         * 春卷
         */
        SPRING_ROLLS;
    }
    enum MainCourse implements Food {
        /**
         * 意面
         */
        LASAGNE,
        /**
         * 玉米饼
         */
        BURRITO,
        /**
         * 泰式炒河粉
         */
        PAD_THAI,
        /**
         * 扁豆
         */
        LENTILS,
        /**
         * 豆沙
         */
        HUMMUS,
        /**
         * 咖喱肉
         */
        VINDALOO;
    }
    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL
    }
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA
    }
}
