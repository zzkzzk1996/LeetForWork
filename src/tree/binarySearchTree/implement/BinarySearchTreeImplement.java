package tree.binarySearchTree.implement;

import tree.binarySearchTree.MyBinarySearchTree;
import tree.binarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-28 17:22
 */

public class BinarySearchTreeImplement implements MyBinarySearchTree {

    private TreeNode root;

    int size;

    public BinarySearchTreeImplement() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(int val) {
        root = add(root, val);
    }

    private TreeNode add(TreeNode node, int val) {
        if (node == null) {
            size++;
            return new TreeNode(val);
        }

        if (node.val == val) {
            throw new IllegalArgumentException("Already exists");
        } else if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }
        return node;
    }

    @Override
    public void remove(int val) {
        root = remove(root, val);
    }

    private TreeNode remove(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val > val) {
            node.left = remove(node.left, val);
        } else if (node.val < val) {
            node.right = remove(node.right, val);
        } else {
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            }
            TreeNode min = findMin(node.right);
            node.val = min.val;
            node.right = remove(node.right, node.val);
            size--;
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(TreeNode node, int val) {
        if (node == null) return false;

        if (node.val == val) {
            return true;
        } else if (node.val > val) {
            return contains(node.left, val);
        } else {
            return contains(node.right, val);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void print() {
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println((level + 1) + " : ");
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.println((cur.val) + " : ");
                if (cur.left != null) {
                    System.out.println("Left : " + cur.left.val);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    System.out.println("Right : " + cur.right.val);
                    queue.offer(cur.right);
                }
                System.out.println();
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeImplement binarySearchTreeImplement = new BinarySearchTreeImplement();
        binarySearchTreeImplement.add(8);
        binarySearchTreeImplement.add(5);
        binarySearchTreeImplement.add(6);
        binarySearchTreeImplement.add(3);
        binarySearchTreeImplement.add(10);
        binarySearchTreeImplement.add(9);
        binarySearchTreeImplement.add(11);
        binarySearchTreeImplement.remove(8);
        binarySearchTreeImplement.print();
        System.out.println(binarySearchTreeImplement.contains(5));
        System.out.println(binarySearchTreeImplement.contains(1));
    }
}
