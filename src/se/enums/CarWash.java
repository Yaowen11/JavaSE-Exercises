package se.enums;

import java.util.EnumSet;

/**
 * @author zhangyaowen
 */
public class CarWash {
    public enum Cycle {
        /**
         * under
         */
        UNDERBODY {
            @Override
            void action() {
                System.out.println("Spraying the under body");
            }
        },
        /**
         * wheel
         */
        WHEELWASH {
            @Override
            void action() {
                System.out.println("Washing the wheels");
            }
        },
        /**
         * prewash
         */
        PREWASH {
            @Override
            void action() {
                System.out.println("Loosening the dirt");
            }
        },
        /**
         * basic
         */
        BASIC {
            @Override
            void action() {
                System.out.println("The basic wash");
            }
        },
        /**
         * hot wax
         */
        HOTWAX {
            @Override
            void action() {
                System.out.println("Applying hot wax");
            }
        },
        /**
         * binse
         */
        RINSE {
            @Override
            void action() {
                System.out.println("Rinsing");
            }
        },
        /**
         * blowdry
         */
        BLOWDRY {
            @Override
            void action() {
                System.out.println("Blowing dry");
            }
        };
        /**
         *
         */
        abstract void action();
    }
    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);
    public void add(Cycle cycle) {
        cycles.add(cycle);
    }
    public void washCar() {
        cycles.forEach(Cycle::action);
    }
    public static void main(String[] args) {
        CarWash wash = new CarWash();
        System.out.println(wash);
        wash.washCar();
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOTWAX);
        System.out.println(wash);
        wash.washCar();
    }
}
