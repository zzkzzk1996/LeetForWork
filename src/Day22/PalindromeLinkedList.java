package Day22;

/**
 * @program: LeetForWork
 * @description: 234. Palindrome Linked List
 * @author: Zekun Zhang
 * @create: 2019-09-22 16:07
 */

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = dummy.next;
        slow = slow.next;
        ListNode pre = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        while (pre != null && fast != null) {
            if (pre.val != fast.val) {
                return false;
            }
            pre = pre.next;
            fast = fast.next;
        }
        return true;
    }
}
