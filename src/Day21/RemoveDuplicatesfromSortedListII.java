package Day21;

/**
 * @program: LeetForWork
 * @description: 82. Remove Duplicates from Sorted List II
 * @author: Zekun Zhang
 * @create: 2019-09-21 19:02
 */

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        int value = cur.val;
        boolean check = false;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                value = cur.val;
                pre.next = cur.next.next;
                cur = pre.next;
                check = true;
            } else if (check && cur.val == value) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int value = cur.next.val;
                while (cur.next != null && value == cur.next.val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
