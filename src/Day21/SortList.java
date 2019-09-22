package Day21;

/**
 * @program: LeetForWork
 * @description: 148. Sort List
 * @author: Zekun Zhang
 * @create: 2019-09-21 19:28
 */

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(next));
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a != null) cur.next = a;
        if (b != null) cur.next = b;
        return dummy.next;
    }

    private ListNode getMid(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
