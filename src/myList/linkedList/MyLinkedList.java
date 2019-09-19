package myList.linkedList;

public interface MyLinkedList<E> {
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
     * add the element the position at index
     * @param data
     * @param index
     */
    void add(int index, E data);

    /**
     * add element to the list
     * @param data
     * @return
     */
    boolean add(E data);

    /**
     * add an element to the first pos
     * @param data
     */
    void addFirst(E data);

    /**
     * add an element to the last pos
     * @param data
     */
    void addLast(E data);

    /**
     * remove the first element
     * @return
     */
    E removeFirst();

    /**
     * remove the last element
     * @return
     */
    E removeLast();

    /**
     * remove the very element
     * @param data
     * @return
     */
    boolean remove(E data);

    /**
     * remove the very element with index
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * get the element with index
     * @param index
     * @return
     */
    E get(int index);

    /**
     * get the first element
     * @return
     */
    E getFirst();

    /**
     * get the last element
     * @return
     */
    E getLast();

    /**
     * set the element with index
     * @param index
     * @param data
     */
    void set(int index, E data);

    /**
     * check if the list contains the element
     * @param data
     * @return
     */
    boolean contains(E data);

    /**
     * print
     */
    void print();

}
