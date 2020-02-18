package se.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyaowen
 */
public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = la;
        ls[0] = new ArrayList<>();
        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();

    }
}
