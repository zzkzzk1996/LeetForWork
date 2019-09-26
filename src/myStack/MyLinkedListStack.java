package myStack;

public interface MyLinkedListStack<E> {
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
}
