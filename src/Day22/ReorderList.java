package Day22;

/**
 * @program: LeetForWork
 * @description: 143. Reorder List
 * @author: Zekun Zhang
 * @create: 2019-09-22 16:10
 */

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mid = getMid(head);
        mid.next = reverse(mid.next);
        ListNode temp = mid.next;
        mid.next = null;
        mid = temp;
        while (head != null && mid != null) {
            ListNode t1 = head.next;
            ListNode t2 = mid.next;
            head.next = mid;
            // head = t1 == null ? t2 : t1;
            if (t1 == null) break;
            head = t1;
            mid.next = t1;
            mid = t2;
        }
        return;
    }

    private ListNode getMid(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
