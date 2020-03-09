package zDay19;

/**
 * @program: LeetForWork
 * @description: 708. Insert into a Sorted Circular Linked List
 * @author: Zekun Zhang
 * @create: 2020-03-08 13:03
 */

public class InsertintoaSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if (head == null){
            Node temp = new Node(insertVal, null);
            temp.next = temp;
            return temp;
        }
        Node cur = head;
        if (cur.val > insertVal) {
            while (cur.next.val >= cur.val && cur.next != head) cur = cur.next;
            while (insertVal > cur.next.val) cur = cur.next;
        } else if (cur.val < insertVal) {
            while (insertVal > cur.next.val && cur.next.val >= cur.val && cur.next != head) cur = cur.next;
        }
        Node temp = new Node(insertVal, cur.next);
        cur.next = temp;
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
}
