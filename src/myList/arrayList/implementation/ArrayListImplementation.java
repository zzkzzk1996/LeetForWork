package myList.arrayList.implementation;

import myList.arrayList.MyArrayList;

/**
 * @program: LeetForWork
 * @description: Implementation for array list
 * @author: Zekun Zhang
 * @create: 2019-09-10 10:13
 */

public class ArrayListImplementation<E> implements MyArrayList<E> {
    private E[] data;
    private int size;

    public ArrayListImplementation() {
        this(10);
    }

    public ArrayListImplementation(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * time: O(1)
     *
     * @return
     */
    @Override
    public int capacity() {
        return data.length;
    }

    /**
     * time: O(1)
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * time: O(1)
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * time: O(1)
     *
     * @param element
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    /**
     * time: O(n)
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Out of range");
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    /**
     * time: O(n)
     *
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * time: O(1)
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Out of range");
        }
        return data[index];
    }

    /**
     * time: O(1)
     *
     * @param index
     * @param element
     */
    @Override
    public void set(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Out of range");
        }
        data[index] = element;
    }

    /**
     * time: O(n)
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Out of range");
        }
        E result = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;

        if (data.length / 4 == size && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return result;
    }

    /**
     * time: O(n)
     *
     * @param element
     */
    @Override
    public void remove(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                index = i;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("No such element");
        }
        remove(index);
    }

    @Override
    public void print() {
        System.out.println("Size" + size);
        System.out.println("Capacity" + data.length);
        for (int i = 0; i < size; i++) {
            System.out.println(data[i] + " ");
        }
    }

    /**
     * time: O(n)
     * @param capacity
     */
    @Override
    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
