package Day23;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 138. Copy List with Random Pointer
 * @author: Zekun Zhang
 * @create: 2019-09-23 23:50
 */

//TODO UNDERSTAND DEEP COPY

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

public class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val, cur.next, cur.random));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
