package myStack.implementation;

import myStack.MyLinkedListStack;

import java.util.LinkedList;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-26 15:46
 */

public class LinkedListImplementation<E> implements MyLinkedListStack<E> {

    private LinkedList<E> linkedList;

    public LinkedListImplementation() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public void print() {
        System.out.println("Size" + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
    }
}
