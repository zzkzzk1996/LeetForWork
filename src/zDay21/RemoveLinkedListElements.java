package zDay21;

/**
 * @program: LeetForWork
 * @description: 203. Remove Linked List Elements
 * @author: Zekun Zhang
 * @create: 2020-03-13 15:12
 */

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val && head.next == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode temp = cur.next;
                cur.next = cur.next.next;
                temp = null;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){}
    }
}
