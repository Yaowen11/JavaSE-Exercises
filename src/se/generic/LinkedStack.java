package se.generic;

/**
 * @author zhangyaowen
 */
public class LinkedStack<T> {

    private static class Node<U> {
        U item;

        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    /**
     * 初始化包含一个空节点的栈
     */
    private Node<T> top = new Node<>();

    /**
     * 新建一个包含类型 T item 的 node，以初始空节点为 next 节点，并将该节点赋给顶部节点
     * @param item node 元素
     */
    public void push(T item) {
        top = new Node<>(item, top);
    }

    /**
     * 返回顶部 item，如果顶部还有 next 节点，将 next 指向 top
     * @return T
     */
    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        String parse = "Parse or sun!";
        String deli = " ";
        LinkedStack<String> linkedStack = new LinkedStack<>();
        for (String s: parse.split(deli)) {
            linkedStack.push(s);
        }
        String s;
        while ((s = linkedStack.pop()) != null) {
            System.out.println(s);
        }
    }
}
