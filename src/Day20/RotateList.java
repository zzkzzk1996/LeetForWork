package Day20;

/**
 * @program: LeetForWork
 * @description: 61. Rotate List
 * @author: Zekun Zhang
 * @create: 2019-09-20 23:28
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        k = k % len;
        if (k == 0) return dummy.next;
        else {
            cur.next = dummy.next;
            for (int i = 0; i < len - k; i++) {
                cur = cur.next;
            }
            dummy.next = cur.next;
            cur.next = null;
            return dummy.next;
        }
    }
}
