package Day21;

/**
 * @program: LeetForWork
 * @description: 2. Add Two Numbers
 * @author: Zekun Zhang
 * @create: 2019-09-21 21:13
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int carry = 0, value = 0;
        while (l1 != null || l2 != null) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            value = v1 + v2 + carry;
            carry = value / 10;
            value %= 10;
            cur.next = new ListNode(value);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return res.next;
    }
}
