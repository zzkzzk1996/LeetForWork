package Day21;

/**
 * @program: LeetForWork
 * @description: 147. Insertion Sort List
 * @author: Zekun Zhang
 * @create: 2019-09-21 22:22
 */

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = null;
        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {
                ListNode temp = cur.next;
                cur.next = cur.next.next;
                pre = dummy;
                while (temp.val >= pre.next.val) {
                    pre = pre.next;
                }
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return dummy.next;
    }
}
