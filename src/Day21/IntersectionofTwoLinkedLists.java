package Day21;

/**
 * @program: LeetForWork
 * @description: 160. Intersection of Two Linked Lists
 * @author: Zekun Zhang
 * @create: 2019-09-21 21:14
 */

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode check = null;
        while (curA != curB) {
            if (curA != null && curA.next == null) {
                if (check != null) {
                    if (check != curA) return null;
                } else {
                    check = curA;
                }
            }
            if (curB != null && curB.next == null) {
                if (check != null) {
                    if (check != curB) return null;
                } else {
                    check = curB;
                }
            }
            curA = curA == null ? headA : curA.next;
            curB = curB == null ? headB : curB.next;
        }
        return curA;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
