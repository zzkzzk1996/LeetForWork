package zDay16;

/**
 * @program: LeetForWork
 * @description: 2. Add Two Numbers
 * @author: Zekun Zhang
 * @create: 2020-03-03 15:53
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int carry = 0, cur = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            cur = v1 + v2 + carry;
            carry = cur / 10;
            node.next = new ListNode(cur % 10);
            node = node.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            node.next = new ListNode(1);
        }
        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
