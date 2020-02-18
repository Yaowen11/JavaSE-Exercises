package se.base;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhangyaowen
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        Arrays.sort(planets);
        System.out.println(planets);
        Arrays.sort(planets, (first, second)->first.length() - second.length());
        System.out.println(planets);
        Timer t = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
