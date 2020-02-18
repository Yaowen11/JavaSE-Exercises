package se.generic.generator;

import se.generic.generation.Generator;

import java.util.Objects;
import java.util.Random;

/**
 * @author zhangyaowen
 */
public class RandomGenerator {

    private static Random r = new Random(41);

    public static class Boolean implements Generator<java.lang.Boolean> {
        public Boolean(){}
        @Override
        public java.lang.Boolean next() {
            return r.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        public Byte(){}
        @Override
        public java.lang.Byte next() {
            return (byte) r.nextInt();
        }
    }

    public static class Character implements Generator<java.lang.Character> {
        public Character(){}
        @Override
        public java.lang.Character next() {
            return CountingGenerator.chars[r.nextInt(CountingGenerator.chars.length)];
        }
    }

    public static class String implements Generator<java.lang.String> {
        private int length;
        public String() {}
        public String(int length) {
            this.length = length;
        }
        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = CountingGenerator.chars[r.nextInt(CountingGenerator.chars.length)];
            }
            return new java.lang.String(buf);
        }
    }

    public static class Short implements Generator<java.lang.Short> {
        public Short(){}
        @Override
        public java.lang.Short next() {
            return (short) r.nextInt();
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {

        private int mod = 10000;

        public Integer() {}

        public Integer(int mod) {
            this.mod = mod;
        }

        @Override
        public java.lang.Integer next() {
            return r.nextInt(mod);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Integer integer = (Integer) o;
            return mod == integer.mod;
        }

        @Override
        public int hashCode() {
            return Objects.hash(mod);
        }

        @Override
        public java.lang.String toString() {
            return "Integer{" +
                    "mod=" + mod +
                    '}';
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        public Long(){}
        @Override
        public java.lang.Long next() {
            return r.nextLong();
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        public Float(){}
        @Override
        public java.lang.Float next() {
            return r.nextFloat();
        }
    }

    public static class Double implements Generator<java.lang.Double> {
        public Double(){}
        @Override
        public java.lang.Double next() {
            return r.nextDouble();
        }
    }

}
