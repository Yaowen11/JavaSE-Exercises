package think.eleven;

import java.util.*;

public class ExceptionDemo {
    private static class TryException {
        public void dum() {
            try {
                throw new Exception("this is inner class");
            } catch (Exception exception) {
                System.out.println("catch exception and dump exception message: " + exception.getMessage());
            } finally {
                System.out.println("finally is execute!");
            }
        }

        public void nullException(String init) {
            try {
                System.out.println(init.toLowerCase());
            } catch (NullPointerException e) {
                System.out.println("catch NullPointerException: " + e.getMessage());
            }
        }

        public int outOfBounds(int[] ints) {
            try {
                System.out.println("int[] index 10 is: " + ints[10] + " int[] length: " + ints.length);
                ints[10] = 19;
                return ints[10];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("catch ArrayIndexOutOfBoundsException: " + e.getMessage());
            }
            return 0;
        }

        public static void dump() {
            TryException exception = new TryException();
            exception.dum();
            exception.nullException(null);
            int length = 0;
            int[] ints = new int[0];
            while (true) {
                try {
                    if (exception.outOfBounds(ints) > 0) {
                        System.out.println(length);
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) {
                }
                ints = new int[length++];
            }
            System.out.println(Arrays.toString(ints));
            System.out.println("use while loop recover exception length: " + length);
        }
        
    }
    private static class MyException extends Exception {
        private int x;
        public MyException() {}
        public MyException(String msg) { super(msg); }
        public MyException(String msg, int x) {
            super(msg);
            this.x = x;
        }
        public int val() { return x;};
        @Override public String getMessage() {
            return "Detail Message: " + x + " " + super.getMessage();
        }
    }
    private static class ExtraFeautures {
        public static void f() throws MyException {
            System.out.println("Throwing MyException from f()");
            throw new MyException();
        }
        public static void g() throws MyException {
            System.out.println("Throwing MyException from g()");
            throw new MyException("Originated in g()");
        }
        public static void h() throws MyException {
            System.out.println("Throwing MyException2 from h()");
            throw new MyException("Originated in h()", 47);
        }
        public static void dump() {
            try {
                f();
            } catch (MyException e) {
                e.printStackTrace(System.out);
            }
            try {
                g();
            } catch (MyException e) {
                e.printStackTrace(System.out);
            }
            try {
                h();
            } catch (MyException e) {
                e.printStackTrace(System.out);
                System.out.println("e.val() = " + e.val());
            }
        }
    }
    private static class Rethrowing {
        public static void f() throws Exception {
            System.out.println("originating the exception in f()");
            throw new Exception("throw from f()");
        }
        public static void g() throws Exception {
            try {
                f();
            } catch (Exception e) {
                System.out.println("Inside g() e.printStackTrace()");
                e.printStackTrace(System.out);
                throw e;
            }
        }
        public static void h() throws Exception {
            try {
                f();
            } catch (Exception e) {
                System.out.println("Inside h(), e.printStackTrace()");
                e.printStackTrace(System.out);
                throw (Exception) e.fillInStackTrace();
            }
        }

        public static void dump() {
            try {
                g();
            } catch (Exception e) {
                System.out.println("main: printStackTrace()");
                e.printStackTrace(System.out);
            }
            try {
                h();
            } catch (Exception e) {
                System.out.println("main: printStackTrace()");
                e.printStackTrace(System.out);
            }
        }
    }
    public static void main(String[] args) {
        Rethrowing.dump();
    }
}