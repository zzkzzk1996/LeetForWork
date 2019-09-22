package Day21;

/**
 * @program: LeetForWork
 * @description: 142. Linked List Cycle II
 * @author: Zekun Zhang
 * @create: 2019-09-21 23:17
 */

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
