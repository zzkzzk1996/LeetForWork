package myStack;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-26 15:22
 */

public interface MyArrayStack<E> {
    /**
     * capacity
     * @return
     */
    int capacity();

    /**
     * actual size
     * @return
     */
    int size();

    /**
     * judge whether the array list is empty
     * @return
     */
    boolean isEmpty();

    /**
     * push
     * @param e
     */
    void push(E e);

    /**
     * peek the first element
     * @return
     */
    E peek();

    /**
     * pop
     * @return
     */
    E pop();

    /**
     * print
     */
    void print();

    /**
     * resize the stack by modify the capacity
     * @param capacity
     */
    void resize(int capacity);
}
