package think.fifteen.genericinterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyw
 * @date 2020/8/22 20:44
 */
public class ListMaker {
    <T> List<T> create() {
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        ListMaker maker = new ListMaker();
        List<String> strings = maker.create();
    }
}
