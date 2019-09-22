package Day21;

/**
 * @program: LeetForWork
 * @description: 369. Plus One Linked List
 * @author: Zekun Zhang
 * @create: 2019-09-21 20:03
 */

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            head.val += 1;
            if (head.val == 10) {
                head.val = 0;
                ListNode dummy = new ListNode(1);
                dummy.next = head;
                return dummy;
            }
            return head;
        }
        return helper(head, 0);
    }

    private ListNode helper(ListNode head, int count) {
        if (head.next == null) {
            head.val += 1;
        } else {
            head.next = helper(head.next, count + 1);
            if (head.next.val == 10) {
                head.next.val = 0;
                head.val += 1;
                if (count == 0 && head.val == 10) {
                    head.val = 0;
                    ListNode dummy = new ListNode(1);
                    dummy.next = head;
                    return dummy;
                }
            }
        }

        return head;
    }

    public ListNode plusOne1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) i = j;
        }
        i.val++;
        while (i.next != null) {
            i = i.next;
            i.val = 0;
        }
        return dummy.val == 0 ? dummy.next : dummy;
    }



    public ListNode plusOne2(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int carry = 1;
        while (carry > 0 || cur.next != null) {
            if (cur.next != null) {
                cur = cur.next;
                carry += cur.val;
                cur.val = carry % 10;
                carry /= 10;
            } else {
                cur.next = new ListNode(1);
                carry = 0;
            }
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
