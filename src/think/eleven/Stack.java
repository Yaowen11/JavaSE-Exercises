package think.eleven;

import think.Constant;

import java.util.*;

/**
 * @author zyw
 * @date 2020/5/30 16:32
 */
public class Stack<T> {
    private final LinkedList<T> linkedList = new LinkedList<>();
    public void push(T v) {
        linkedList.addFirst(v);
    }
    public T peek() {
        return linkedList.getFirst();
    }
    public T pop() {
        return linkedList.removeFirst();
    }
    public boolean empty() {
        return linkedList.isEmpty();
    }
    @Override
    public String toString() {
        return linkedList.toString();
    }
    public static void main(String[] args) {
//        comp();
        String express = "3 + 5 * 8 - 6";
        compute(express);
//        System.out.println(32 + 231 + 29 - 100 * 199 / 29);
    }
    public static void dump() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < Constant.TEN; i++) {
            stack.push(i);
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
    public static void comp() {
        String origin = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
        Stack<String> characterStack = new Stack<>();
        List<String> linkedList = List.of(origin.split(""));
        System.out.println(linkedList);
        ListIterator<String> listIterator = linkedList.listIterator();
        String first;
        while (listIterator.hasNext()) {
            first = listIterator.next();
            if ("+".equals(first)) {
                characterStack.push(listIterator.next());
            } else if ("-".equals(first)) {
                System.out.print(characterStack.pop() + " ");
            }
        }
    }
    public static void compute(String expression) {
        final Map<String, Integer> operatorLevel = new HashMap<>();
        operatorLevel.put("*", 1);
        operatorLevel.put("/", 1);
        operatorLevel.put("+", 0);
        operatorLevel.put("-", 0);
        Stack<Integer> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();
        final String split = " ";
        System.out.println(Arrays.toString(expression.split(split)));
        for (String s : expression.split(split)) {
            if (operatorLevel.containsKey(s)) {
                if (operators.empty()) {
                    operators.push(s);
                    continue;
                }
                while (operatorLevel.get(s) <= operatorLevel.get(operators.peek())) {
                    numbers.push(computeInt(numbers.pop(), numbers.pop(), operators.pop()));
                }
                operators.push(s);
            } else {
                numbers.push(Integer.parseInt(s));
            }
        }
        while (!operators.empty()) {
            numbers.push(computeInt(numbers.pop(), numbers.pop(), operators.pop()));
        }
        System.out.println(numbers);
    }

    private static int computeInt(Integer num1, Integer num2, String operator) {
        final Map<String, Integer> operatorMappingOperator = new HashMap<>();
        operatorMappingOperator.put("*", 1);
        operatorMappingOperator.put("/", 2);
        operatorMappingOperator.put("+", 3);
        operatorMappingOperator.put("-", 4);
        int result = 0;
        switch (operatorMappingOperator.get(operator)) {
            case 1:
                result = num1 * num2;
                break;
            case 2:
                result = num1 / num2;
                break;
            case 3:
                result = num1 + num2;
                break;
            case 4:
                result = num1 - num2;
                break;
            default:
                break;
        }
        System.out.printf("num1: %d num2: %d operator: %s result: %d\n", num1, num2, operator, result);
        return result;
    }
}
