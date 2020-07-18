package heap.implementation;

import heap.MyMaxHeap;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-17 15:15
 */

public class MyMaxHeapImplementation<E extends Comparable<E>> implements MyMaxHeap<E> {

    private int capacity;

    private int size;

    private E[] data;

    public MyMaxHeapImplementation() {
        this.capacity = 16;
        this.size = 0;
        this.data = (E[]) new Comparable[capacity];
    }

    public MyMaxHeapImplementation(E[] data) {
        this.data = data;
        this.capacity = data.length;
        this.size = data.length;
        heapify(data);
    }

    /**
     * Build a Priority Queue
     * @param data
     */
    private void heapify(E[] data) {
        for (int i = getParentIndex(size - 1); i >= 0; i--) {
            siftDownHeapify(i);
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

    @Override
    public boolean offer(E element) {
        if (size == capacity) {
            expandCapacity();
        }
        data[size] = element;
        size++;
        siftUp();
        return true;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new IllegalArgumentException("Heap is empty");
        }
        return data[0];
    }

    @Override
    public E poll() {
        if (size == 0) {
            throw new IllegalArgumentException("Heap is empty");
        }
        E item = data[0];
        data[0] = data[size - 1];
        data[size - 1] = null;
        size--;
        siftDown();
        return item;
    }

    @Override
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");

        }
    }

    private void expandCapacity() {
        E[] temp = (E[]) new Comparable[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            temp[i] = data[i];
        }
        capacity *= 2;
        data = temp;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private E getParent(int childIndex) {
        return data[getParentIndex(childIndex)];
    }

    private E getLeftChild(int parentIndex) {
        return data[getLeftChildIndex(parentIndex)];
    }

    private E getRightChild(int parentIndex) {
        return data[getRightChildIndex(parentIndex)];
    }

    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void siftUp() {
        int index = size - 1;
        while (getParentIndex(index) >= 0 && getParent(index).compareTo(data[index]) < 0) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void siftDown() {
        int index = 0;
        while (getLeftChildIndex(index) < size) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && getRightChild(index).compareTo(getLeftChild(index)) > 0) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (data[index].compareTo(data[biggerChildIndex]) > 0) {
                break;
            } else {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;
        }
    }

    private void siftDownHeapify(int index) {
        while (getLeftChildIndex(index) < size) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && getRightChild(index).compareTo(getLeftChild(index)) > 0) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (data[index].compareTo(data[biggerChildIndex]) > 0) {
                break;
            } else {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;
        }
    }
}
