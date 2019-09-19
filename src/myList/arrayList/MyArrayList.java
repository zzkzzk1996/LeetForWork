package myList.arrayList;

public interface MyArrayList<E> {
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
     * add element to the last position of the array
     * @param element
     */
    void add(E element);

    /**
     * add element to the very position of the array
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * find the very element
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * find the very element and return
     * @param index
     * @return
     */
    E get(int index);

    /**
     * modify the very element
     * @param index
     * @param element
     */
    void set(int index, E element);

    /**
     * remove element by index
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * remove element by element
     * @param element
     */
    void remove(E element);

    /**
     * print
     */
    void print();

    /**
     * resize the array by modify the capacity
     * @param capacity
     */
    void resize(int capacity);
}
