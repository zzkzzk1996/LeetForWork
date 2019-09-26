package myStack.implementation;

import myStack.MyArrayStack;

import java.util.EmptyStackException;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-26 15:25
 */

public class ArrayStackImplementation<E> implements MyArrayStack<E> {
    private E[] data;

    private int elementCount;

    public ArrayStackImplementation(){
        this(10);
    }

    public ArrayStackImplementation(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.elementCount = 0;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    }

    @Override
    public void push(E e) {
        if (elementCount == data.length) {
            resize(data.length * 2);
        }
        data[elementCount++] = e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            new EmptyStackException();
        }
        return data[elementCount - 1];
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            new EmptyStackException();
        }
        E obj = peek();
        elementCount--;
        data[elementCount] = null;
        return obj;
    }

    @Override
    public void print() {
        System.out.println("Size" + elementCount);
        System.out.println("Capacity" + data.length);
        for (int i = 0; i < elementCount; i++) {
            System.out.print(data[i] + " ");
        }
    }

    @Override
    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < elementCount; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
