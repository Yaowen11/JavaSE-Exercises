package think.twenty;


import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class Single {

    public static void main(String[] args) {
        int threads = 2000;
        var executors = Executors.newFixedThreadPool(threads);
        Callable<Person> callable = () -> {
            var person = SingleObject.getPerson();
            if (person == null) {
                throw new NullPointerException("null person");
            }
            return person;
        };
        for (int i = 0; i < threads; i++) {
            executors.submit(callable);
        }
        executors.shutdown();
        System.out.println("execute done");
        System.exit(0);
    }


}

class SingleObject {

    public static Person person;

    public static Person getPerson() {
        if (person == null) {
            synchronized (SingleObject.class) {
                person = new Person();
            }
        }
        return person;
    }
}

class Person {
    private int id;
    private String name;
}