package zDay16;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 116. Populating Next Right Pointers in Each Node
 * @author: Zekun Zhang
 * @create: 2020-03-03 16:27
 */

public class PopulatingNextRightPointersinEachNode {
    /**
     * BFS
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (pre != null) pre.next = cur;
                pre = cur;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return root;
    }

    class Node {
        Node left;
        Node right;
        Node next;
    }
}
