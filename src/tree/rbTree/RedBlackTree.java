package tree.rbTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-30 17:16
 */

public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private Node root;

    private class Node {

        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int size;

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }

    public RedBlackTree() {
    }

    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.color == RED;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Empty");
        }
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if      (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else              return node.value;
        }
        return null;
    }

    private Node leftRotate(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rightRotate(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColor(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Empty");
        }
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, RED, 1);

        int cmp = key.compareTo(node.key);
        if      (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else              node.value = value;

        if (isRed(node.right) && !isRed(node.left))    node = leftRotate(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rightRotate(node);
        if (isRed(node.left) && isRed(node.right))     flipColor(node);

        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    private void check() {
        if (!isBST()) System.out.println("Not BST");
        if (!isSize()) System.out.println("Not size");
        if (!isBalanced()) System.out.println("Not balanced");
        if (!is23()) System.out.println("Not 23T");
        System.out.println("Correct");
    }

    private boolean isBST() {
        return helper(root, null, null);
    }

    private boolean helper(Node node, Key min, Key max) {
        if (node == null) return true;
        if (min != null && node.key.compareTo(min) <= 0) return false;
        if (max != null && node.key.compareTo(max) >= 0) return false;
        return helper(node.left, min, node.key) && helper(node.right, node.key, max);
    }

    private boolean isBalanced() {
        int black = 0;
        Node node = root;
        while (node != null) {
            if (!isRed(node)) {
                black++;
            }
            node = node.left;
        }
        return isBalanced(root, black);
    }

    private boolean isBalanced(Node node, int black) {
        if (node == null) return black == 0;
        if (!isRed(node)) black--;
        return isBalanced(node.left, black) && isBalanced(node.right, black);
    }

    private boolean isSize() {
        return isSize(root);
    }

    private boolean isSize(Node node) {
         if (node == null) return true;
         if (node.size != size(node.left) + size(node.right) + 1) return false;
         return isSize(node.left) && isSize(node.right);
    }

    private boolean is23() {
        return is23(root);
    }

    private boolean is23(Node node) {
        if (node == null) return true;
        if (isRed(node.right)) return false;
        if (node != root && isRed(node) && isRed(node.left)) return false;
        return is23(node.left) && is23(node.right);
    }

    private void print() {
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("Level " + (level + 1) + " : ");
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                System.out.println((cur.key));
                if (cur.left != null) {
                    System.out.println("Left : " + cur.left.key + " Color : " + cur.left.color);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    System.out.println("Right : " + cur.right.key + " Color : " + cur.right.color);
                    queue.offer(cur.right);
                }
                System.out.println();
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        RedBlackTree<Integer, Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree.put(12, 1);
        redBlackTree.put(1, 1);
        redBlackTree.put(9, 1);
        redBlackTree.put(2, 1);
        redBlackTree.put(0, 1);
        redBlackTree.put(11, 1);
        redBlackTree.put(7, 1);
        redBlackTree.put(19, 1);
        redBlackTree.put(4, 1);
        redBlackTree.put(15, 1);
        redBlackTree.put(18, 1);
        redBlackTree.put(5, 1);
        redBlackTree.put(14, 1);
        redBlackTree.put(13, 1);
        redBlackTree.put(10, 1);
        redBlackTree.put(16, 1);
        redBlackTree.put(6, 1);
        redBlackTree.put(3, 1);
        redBlackTree.put(8, 1);
        redBlackTree.put(17, 1);
        redBlackTree.check();
        redBlackTree.print();
    }
}
