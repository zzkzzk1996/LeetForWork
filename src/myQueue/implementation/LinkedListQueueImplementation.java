package myQueue.implementation;

import myQueue.MyQueue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-30 11:58
 */

public class LinkedListQueueImplementation<E> implements MyQueue<E> {
    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedListQueueImplementation() {
        this.head = null;
        this.tail = null ;
        this.size = 0;
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
    public boolean offer(E element) {
        if (tail == null) {
            tail = new ListNode(element);
            head = tail;
        } else {
            tail.next = new ListNode(element);
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty Queue");
        }
        return (E) head.data;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty Queue");
        }
        ListNode res = head;
        head = head.next;
        res.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return (E) res.data;
    }

    @Override
    public void print() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    private class ListNode<E> {
        public E data;

        public ListNode next;

        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
