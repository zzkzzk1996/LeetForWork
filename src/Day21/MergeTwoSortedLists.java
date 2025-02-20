package Day21;

/**
 * @program: LeetForWork
 * @description: 21. Merge Two Sorted Lists
 * @author: Zekun Zhang
 * @create: 2019-09-21 21:42
 */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return res.next;
    }
}
