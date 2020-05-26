package algorithm.leetcode.medium;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字 2->4->3 5->6->4 7->0->8 342 + 465 = 807
 * @author z
 * @date 2020/5/25 9:49
 */
public class AddTwoNumber {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 1.翻转链表
     * @param node
     * @param node2
     * @return
     */
    public ListNode addTwoNumbers(ListNode node, ListNode node2) {
        class Node2Int {
            private ListNode firstNode;
            Node2Int(ListNode node) {
                firstNode = node;
            }
            public int node2Int() {
                return receive(getNodeInt());
            }
            private int getNodeInt() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(firstNode.val);
                while (firstNode.next != null) {
                    firstNode = firstNode.next;
                    stringBuilder.append(firstNode.val);
                }
                return Integer.parseInt(stringBuilder.toString());
            }
            public int receive(int origin) {
                int receive = 0;
                while (origin != 0) {
                    int pop = origin % 10;
                    origin /= 10;
                    receive = receive * 10 + pop;
                }
                return receive;
            }
        }
        int nodeInt = new Node2Int(node).node2Int();
        int node2Int = new Node2Int(node2).node2Int();
        int sumReceive = nodeInt + node2Int;
        System.out.println(sumReceive);
        ListNode receive = new ListNode(0);
        ListNode tmp = receive;
        while (sumReceive != 0) {
            tmp.next = new ListNode(sumReceive % 10);
            tmp = tmp.next;
            sumReceive /= 10;
        }
        return receive.next;
    }

    public ListNode official(ListNode node, ListNode node2) {
        ListNode dumpHead = new ListNode(0);
        ListNode p = node, q = node2, curr = dumpHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dumpHead.next;
    }

    public static void main(String[] args) {
        ListNode listFirstNode = new ListNode(2);
        ListNode listSecondNode = new ListNode(4);
        ListNode listThirdNode = new ListNode(3);
        listFirstNode.next = listSecondNode;
        listSecondNode.next = listThirdNode;
        ListNode list1FirstNode = new ListNode(5);
        ListNode list1SecondNode = new ListNode(6);
        ListNode list1ThirdNode = new ListNode(4);
        list1FirstNode.next = list1SecondNode;
        list1SecondNode.next = list1ThirdNode;
        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode sumListFirst = addTwoNumber.addTwoNumbers(listFirstNode, list1FirstNode);
        while (sumListFirst != null) {
            System.out.println(sumListFirst.val);
            sumListFirst = sumListFirst.next;
        }
    }
}
