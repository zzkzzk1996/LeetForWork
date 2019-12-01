package Day73;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 116. Populating Next Right Pointers in Each Node
 * @author: Zekun Zhang
 * @create: 2019-11-28 15:30
 */

public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i == size - 1) {
                    cur.next = null;
                } else {
                    cur.next = queue.peek();
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    class Node {

        Node left;
        Node right;
        Node next;
        int val;

        Node(int x) {
            val = x;
        }
    }

    public Node connect1(Node root) {
        if (root == null) return root;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
