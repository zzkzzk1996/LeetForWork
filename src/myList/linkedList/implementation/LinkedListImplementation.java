package myList.linkedList.implementation;

import myList.linkedList.MyLinkedList;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-19 16:49
 */

public class LinkedListImplementation<E> implements MyLinkedList<E> {

    private int size;

    private ListNode dummy;

    public LinkedListImplementation() {
        this.dummy = new ListNode(0);
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
    public void add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Out of range");
        }
        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    @Override
    public boolean add(E data) {
        add(size, data);
        return true;
    }

    @Override
    public void addFirst(E data) {
        add(0, data);
    }

    @Override
    public void addLast(E data) {
        add(size, data);
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public boolean remove(E data) {
        ListNode prev = dummy;

        while (prev.next != null) {
            if (prev.next.data.equals(data)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            ListNode delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Out of range");
        }
        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return (E) delNode.data;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Out of range");
        }
        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E) cur.data;
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public void set(int index, E data) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Out of range");
        }
        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = data;
    }

    @Override
    public boolean contains(E data) {
        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.data.equals(data)) return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void print() {
        ListNode cur = dummy.next;
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
