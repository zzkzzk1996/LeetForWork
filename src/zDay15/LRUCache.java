package zDay15;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 146. LRU Cache
 * @author: Zekun Zhang
 * @create: 2020-03-02 11:43
 */

public class LRUCache {
    class Node {

        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.val = val;
        }
    }
    private int cap;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        int value;
        if (!map.containsKey(key)) return -1;
        else {
            Node node = map.get(key);
            value = node.val;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                tail.next = node;
                node.next = null;
                node.prev = tail;
                tail = node;
            }
        }
        return value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node newNode = new Node(key, value);
            if (cap == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                cap++;
                temp = null;
            }

            if (head == null && tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = null;
                tail = tail.next;
            }
            tail = newNode;
            map.put(key, newNode);
            cap--;
        } else {
            Node node = map.get(key);
            node.val = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                tail.next = node;
                node.next = null;
                node.prev = tail;
                tail = node;
            }
        }
    }
}
