package Day21;

/**
 * @program: LeetForWork
 * @description: 237. Delete Node in a Linked List
 * @author: Zekun Zhang
 * @create: 2019-09-21 18:22
 */

public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
