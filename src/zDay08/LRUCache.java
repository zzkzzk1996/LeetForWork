package zDay08;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 146. LRU Cache
 * @author: Zekun Zhang
 * @create: 2020-02-16 07:11
 */

public class LRUCache {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private HashMap<Integer, Node> map;
    private int cap;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        if (node != tail) {
            if (node == head) {
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (cap == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                cap++;
            }
            if (head == null && tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            cap--;

        }
    }
}
