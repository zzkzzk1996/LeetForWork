package zDay21;

/**
 * @program: LeetForWork
 * @description: 21. Merge Two Sorted Lists
 * @author: Zekun Zhang
 * @create: 2020-03-13 17:40
 */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (l1 != null || l2 != null) {
                int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
                int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;
                int v = 0;
                if (v1 > v2) {
                    l2 = l2.next;
                    v = v2;
                } else {
                    l1 = l1.next;
                    v = v1;
                }
                cur.next = new ListNode(v);
                cur = cur.next;
            }
            return dummy.next;
        }
        return l1 == null ? l2 : l1;
    }

    class ListNode {
        ListNode next;
        int val;
        public ListNode(int v) {}
    }
}
