package Day23;

import java.util.Random;

/**
 * @program: LeetForWork
 * @description: 382. Linked List Random Node
 * @author: Zekun Zhang
 * @create: 2019-09-23 17:32
 */

public class LinkedListRandomNode {
    Random rand;
    ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        int res = cur.val;
        int count = 0;
        while (cur != null) {
            if (rand.nextInt(++count) == 0) {
                res = cur.val;
            }
            cur = cur.next;
        }
        return res;
    }
}
