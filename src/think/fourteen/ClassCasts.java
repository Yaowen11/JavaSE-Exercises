package think.fourteen;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zyw
 * @date 2020/6/15 20:46
 */
public class ClassCasts {
    public static void main(String[] args) {
        Building building = new House();
        Class<House> houseType = House.class;
        House house = houseType.cast(building);
        house = (House) building;
        List<Class<? extends Number>> listClass = new LinkedList<>();
        listClass.add(double.class);
        listClass.add(int.class);
        listClass.add(short.class);
    }
}

class Building {}
class House extends Building {}
