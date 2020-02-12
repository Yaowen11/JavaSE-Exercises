package se.generic;

import java.util.ArrayList;
import java.util.List;

interface Processor<T, E extends Exception> {
    /**
     * process
     * @param resultCollector
     * @throws E
     */
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<T>();
        for (Processor<T, E> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class FailureException extends Exception {}

class Processor1 implements Processor<String, FailureException> {
    static int count = 3;
    @Override
    public void process(List<String> resultCollector) throws FailureException {
        if (count -- > 1) {
            resultCollector.add("hep1");
        } else {
            resultCollector.add("Ho!");
        }
        if (count < 0) {
            throw new FailureException();
        }
    }
}

class FailureException1 extends Exception {}

class Processor2 implements Processor<Integer, FailureException1> {
    static int count = 2;
    @Override
    public void process(List<Integer> resultCollector) throws FailureException1 {
        if (count-- == 0) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if (count < 0) {
            throw new FailureException1();
        }
    }
}
/**
 * @author zhangyaowen
 */
public class ThrowGenericException {

    public static void main(String[] args) {
        ProcessRunner<String, FailureException> runner = new ProcessRunner<>();
        int end = 3;
        for (int i = 0; i < end; i++) {
            runner.add(new Processor1());
        }
        try {
            System.out.println(runner.processAll());
        } catch (FailureException e) {
            System.out.println(e);
        }
        ProcessRunner<Integer, FailureException1> runner1 = new ProcessRunner<>();
        for (int i = 0; i < end; i++) {
            runner1.add(new Processor2());
        }
        try {
            System.out.println(runner1.processAll());
        } catch (FailureException1 e) {
            System.out.println(e);
        }
    }
}
