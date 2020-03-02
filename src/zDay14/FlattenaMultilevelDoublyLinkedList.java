package zDay14;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 430. Flatten a Multilevel Doubly Linked List
 * @author: Zekun Zhang
 * @create: 2020-02-28 21:15
 */

public class FlattenaMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) return head;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur.next != null) {
                stack.push(cur.next);
            }
            if (cur.child != null) {
                stack.push(cur.child);
                cur.child = null;
            }
            Node next = stack.isEmpty() ? null : stack.peek();
            cur.next = next;
            if (next != null) next.prev = cur;
        }
        return head;
    }
    class Node {
        Node next;
        Node prev;
        Node child;
    }
}
