package heap;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-17 15:14
 */

public interface MyMaxHeap<E> {
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
     * add element to the first position of the queue
     * @param element
     * @return
     */
    boolean offer(E element);

    /**
     * find the last element and return
     * @return
     */
    E peek();

    /**
     * remove element from the last position of the queue
     * @return
     */
    E poll();

    /**
     * print
     */
    void print();
}
