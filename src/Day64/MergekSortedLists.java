package Day64;

import java.util.PriorityQueue;

/**
 * @program: LeetForWork
 * @description: 23. Merge k Sorted Lists
 * @author: Zekun Zhang
 * @create: 2019-11-03 20:16
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                pq.offer(list.val);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode temp = new ListNode(pq.poll());
            cur.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }
}
