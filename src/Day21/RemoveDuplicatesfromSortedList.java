package Day21;

/**
 * @program: LeetForWork
 * @description: 83. Remove Duplicates from Sorted List
 * @author: Zekun Zhang
 * @create: 2019-09-21 18:56
 */

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
