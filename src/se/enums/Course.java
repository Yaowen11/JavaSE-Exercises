package se.enums;

import se.tools.Enums;

/**
 * @author zhangyaowen
 */
public enum  Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSER(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    Course(Class<? extends Food> foodClass) {
        values = foodClass.getEnumConstants();
    }
    public Food randomSelection() {
        return Enums.random(values);
    }
}
