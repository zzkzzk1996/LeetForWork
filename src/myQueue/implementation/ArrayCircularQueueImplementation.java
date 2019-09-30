package myQueue.implementation;

import myQueue.MyQueue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-30 14:16
 */

public class ArrayCircularQueueImplementation<E> implements MyQueue<E> {
    private E[] data;
    private int head;
    private int tail;

    public ArrayCircularQueueImplementation() {
        this(10);
    }

    public ArrayCircularQueueImplementation(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public int size() {
        return (tail - head + data.length) % data.length;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean offer(E element) {
        data[tail] = element;
        if ((tail = (tail + 1) % data.length) == head) {
            resize(data.length * 2);
        }
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
        E obj = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        return obj;
    }

    @Override
    public void print() {
        System.out.println("Size" + " : " + size());
        System.out.println("Capacity" + " : " + data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[(i + head) % data.length];
        }
        head = 0;
        tail = data.length;
        data = temp;
    }
}
