package Day21;

/**
 * @program: LeetForWork
 * @description: 206. Reverse Linked List
 * @author: Zekun Zhang
 * @create: 2019-09-21 13:53
 */

//TODO IMPORTANT AND UNDERSTAND RECURSIVE

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}
