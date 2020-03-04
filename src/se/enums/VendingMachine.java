package se.enums;

import java.awt.*;
import java.util.EnumMap;

import static se.enums.Input.*;

enum Category {

    MONEY(NICKEL, DIME, QUARTER, DOLLAR),

    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),

    QUIT_TRANSACTION(ABORT_TRANSACTION),

    SHUT_DOWN(STOP);

    private Input[] values;

    Category(Input... types) {
        values = types;
    }

    private static EnumMap<Input, Category> categories = new EnumMap<>(Input.class);

    static {
        for (Category c: Category.class.getEnumConstants()) {
            for (Input type: c.values) {
                categories.put(type, c);
            }
        }
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}
/**
 * @author zhangyaowen
 */
public class VendingMachine {

}