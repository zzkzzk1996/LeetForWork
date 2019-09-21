package Day21;

/**
 * @program: LeetForWork
 * @description: 203. Remove Linked List Elements
 * @author: Zekun Zhang
 * @create: 2019-09-21 18:57
 */

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
