package myList;

public interface MyArrayList {
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
    void add(int element);

    /**
     * add element to the very position of the array
     * @param index
     * @param element
     */
    void add(int index, int element);

    /**
     * find the very element
     * @param element
     * @return
     */
    boolean contains(int element);

    /**
     * find the very element and return
     * @param index
     * @return
     */
    int get(int index);

    /**
     * modify the very element
     * @param index
     * @param element
     */
    void set(int index, int element);

    /**
     * remove element by index
     * @param index
     * @return
     */
    int remove(int index);

    /**
     * remove element by element
     * @param element
     */
    void removeElement(int element);

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
