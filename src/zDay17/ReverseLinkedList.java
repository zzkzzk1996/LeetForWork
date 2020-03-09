package zDay17;

/**
 * @program: LeetForWork
 * @description: 206. Reverse Linked List
 * @author: Zekun Zhang
 * @create: 2020-03-05 10:24
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
