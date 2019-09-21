package Day21;

/**
 * @program: LeetForWork
 * @description: 86. Partition List
 * @author: Zekun Zhang
 * @create: 2019-09-21 13:13
 */

public class PartitionList {
//    public ListNode partition(ListNode head, int x) {
//        if (head == null || head.next == null) return head;
//        ListNode dummy = new ListNode(0);
//        ListNode small = null;
//        ListNode large = null;
//        ListNode largeHead = null;
//        dummy.next = head;
//        ListNode cur = dummy.next;
//        while (cur != null) {
//            if (cur.val < x) {
//                if (small == null) {
//                    small = cur;
//                    dummy.next = small;
//                } else {
//                    small.next = cur;
//                    small = small.next;
//                }
//            } else {
//                if (large == null) {
//                    large = cur;
//                    largeHead = cur;
//                } else {
//                    large.next = cur;
//                    large = large.next;
//                }
//            }
//            cur = cur.next;
//        }
//        if (large != null) {
//            large.next = null;
//        } else {
//            if (small != null) {
//                small.next = largeHead;
//            } else {
//                dummy.next = largeHead;
//            }
//        }
//        return dummy.next;
//    }

    public ListNode partition1(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }

        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }
}
