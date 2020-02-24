package se.enums;

import java.util.EnumMap;
import java.util.Map;

interface Command {
    /**
     * command des
     */
    void action();
}

/**
 * @author zhangyaowen
 */
public class EnumMaps {

    public static void main(String[] args) {

        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);

        em.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("kitchen fire!");
            }
        });

        em.put(AlarmPoints.BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("Bathroom alert!");
            }
        });

        for (Map.Entry<AlarmPoints, Command> e: em.entrySet()) {
            System.out.print(e.getKey() + ": ");
            e.getValue().action();
        }

        System.out.println();

        em.forEach((key, value) -> {
            System.out.print(key + ": ");
            value.action();
        });

        try {
            em.get(AlarmPoints.UTILITY).action();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
