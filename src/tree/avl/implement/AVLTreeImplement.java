package tree.avl.implement;

import tree.avl.AVLNode;
import tree.avl.MyAVLTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-29 17:51
 */

public class AVLTreeImplement implements MyAVLTree {

    private int size;

    private AVLNode root;

    public AVLTreeImplement() {
        this.size = 0;
        this.root = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int val) {
        root = add(root, val);
    }

    private AVLNode add(AVLNode node, int val) {
        if (node == null) {
            size++;
            return new AVLNode(val);
        }

        if (node.val == val) {
            throw new IllegalArgumentException("Already exists");
        } else if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balancedFactor = getBalancedFactor(node);

        if (balancedFactor > 1 && getBalancedFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        if (balancedFactor < -1 && getBalancedFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        if (balancedFactor > 1 && getBalancedFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balancedFactor < -1 && getBalancedFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int getBalancedFactor(AVLNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private AVLNode rightRotate(AVLNode x) {
        AVLNode y = x.left;
        AVLNode c = y.right;

        y.right = x;
        x.left = c;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode c = y.left;

        y.left = x;
        x.right = c;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    private int getHeight(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private boolean isBST(AVLNode node) {
        if (node == null) return true;
        return helper(node, null, null);
    }

    private boolean helper(AVLNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }

    private boolean isBalanced(AVLNode node) {
        if (node == null) return true;
        return helper(node) != -1;
    }

    private int helper(AVLNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    @Override
    public void remove(int val) {
        root = remove(root, val);
    }

    private AVLNode remove(AVLNode node, int val) {
        if (node == null) return null;

        AVLNode changeNode = null;

        if (node.val > val) {
            node.left = remove(node.left, val);
            changeNode = node;
        } else if (node.val < val) {
            node.right = remove(node.right, val);
            changeNode = node;
        } else {
            if (node.left == null) {
                size--;
                changeNode = node.right;
            } else if (node.right == null) {
                size--;
                changeNode = node.left;
            } else {
                AVLNode min = findMin(node.right);
                node.val = min.val;
                node.right = remove(node.right, node.val);
                changeNode = node;
            }
        }

        if (changeNode != null) {
            changeNode.height = 1 + Math.max(getHeight(changeNode.left), getHeight(changeNode.right));

            int balancedFactor = getBalancedFactor(changeNode);

            if (balancedFactor > 1 && getBalancedFactor(changeNode.left) >= 0) {
                return rightRotate(changeNode);
            }

            if (balancedFactor < -1 && getBalancedFactor(changeNode.right) <= 0) {
                return leftRotate(changeNode);
            }

            if (balancedFactor > 1 && getBalancedFactor(changeNode.left) < 0) {
                changeNode.left = leftRotate(changeNode.left);
                return rightRotate(changeNode);
            }

            if (balancedFactor < -1 && getBalancedFactor(changeNode.right) > 0) {
                changeNode.right = rightRotate(changeNode.right);
                return leftRotate(changeNode);
            }
        }

        return changeNode;
    }

    private AVLNode findMin(AVLNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(AVLNode node, int val) {
        if (node == null) return false;
        if (node.val > val) {
            return contains(node.left, val);
        } else if (node.val < val) {
            return contains(node.right, val);
        } else {
            return true;
        }
    }

    private void print() {
        int level = 0;
        Queue<AVLNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("Level " + (level + 1) + " : ");
            for (int i = 0; i < size; i++) {
                AVLNode cur = queue.poll();
                System.out.println((cur.val));
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
        AVLTreeImplement avlTreeImplement = new AVLTreeImplement();
        avlTreeImplement.add(8);
        avlTreeImplement.add(5);
        avlTreeImplement.add(6);
//        avlTreeImplement.print();
        avlTreeImplement.add(3);
        avlTreeImplement.add(10);
        avlTreeImplement.add(9);
        avlTreeImplement.add(11);
        avlTreeImplement.add(2);
        avlTreeImplement.remove(6);
        avlTreeImplement.print();
        System.out.println(avlTreeImplement.isBST(avlTreeImplement.root));
        System.out.println(avlTreeImplement.isBalanced(avlTreeImplement.root));
        System.out.println(avlTreeImplement.size());
    }

}
