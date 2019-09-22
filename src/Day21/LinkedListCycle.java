package Day21;

/**
 * @program: LeetForWork
 * @description: 141. Linked List Cycle
 * @author: Zekun Zhang
 * @create: 2019-09-21 22:27
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
