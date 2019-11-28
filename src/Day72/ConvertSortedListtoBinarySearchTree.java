package Day72;

import Day20.ListNode;

/**
 * @program: LeetForWork
 * @description: 109. Convert Sorted List to Binary Search Tree
 * @author: Zekun Zhang
 * @create: 2019-11-27 19:57
 */

public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = helper(head, slow);
        node.right = helper(slow.next, tail);
        return node;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}


