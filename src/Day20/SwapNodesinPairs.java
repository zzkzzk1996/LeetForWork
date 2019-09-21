package Day20;

/**
 * @program: LeetForWork
 * @description: 24. Swap Nodes in Pairs
 * @author: Zekun Zhang
 * @create: 2019-09-20 22:57
 */

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            ListNode temp = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = temp;
            l1 = l2;
            l2 = l1.next;
        }
        return dummy.next;
    }
}
