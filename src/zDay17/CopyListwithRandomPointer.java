package zDay17;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 138. Copy List with Random Pointer
 * @author: Zekun Zhang
 * @create: 2020-03-04 12:45
 */

public class CopyListwithRandomPointer {
    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        Queue<Node> queue = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        Node cur = new Node(head.val);
        Node dummy = head;
        queue.offer(cur);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            map.put(head, list.size());
            head = head.next;
            if (head != null) {
                node.next = new Node(head.val);
                queue.offer(node.next);
            }
            list.add(node);
        }

        head = dummy;
        dummy = cur;
        while (head != null) {
            if (head.random != null) {
                cur.random = list.get(map.get(head.random));
            }
            cur = cur.next;
            head = head.next;
        }
        return dummy;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = new Node(head.val);
        Node dummy = head;
        map.put(head, cur);
        while (head.next != null) {
            head = head.next;
            cur.next = new Node(head.val);
            cur = cur.next;
            map.put(head, cur);
        }

        head = dummy;
        while (head != null) {
            cur = map.get(head);
            if (head.random != null) {
                cur.random = map.get(head.random);
            }
            head = head.next;
        }
        return map.get(dummy);
    }
}
