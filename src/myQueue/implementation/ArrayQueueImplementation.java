package myQueue.implementation;

import myQueue.MyQueue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-30 12:18
 */

public class ArrayQueueImplementation<E> implements MyQueue<E> {
    private E[] data;
    private int head;
    private int tail;
    private int size;

    public ArrayQueueImplementation(){
        this(10);
    }

    public ArrayQueueImplementation(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
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
        if (tail == data.length) {
            resize(data.length * 2);
        }
        data[tail++] = element;
        size++;
        return true;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw  new IllegalArgumentException("Empty Queue");
        }
        return data[head];
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw  new IllegalArgumentException("Empty Queue");
        }
        E obj = data[head++];
        if (head == data.length) {
            head = 0;
        }
        size--;
        return obj;
    }

    @Override
    public void print() {
        System.out.println("Size" + " : " + size);
        System.out.println("Capacity" + " : " + data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < tail; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
