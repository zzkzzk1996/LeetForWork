package Day21;

/**
 * @program: LeetForWork
 * @description: 25. Reverse Nodes in k-Group
 * @author: Zekun Zhang
 * @create: 2019-09-21 15:03
 */

//TODO AGAIN

public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            count++;
            cur = cur.next;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}
