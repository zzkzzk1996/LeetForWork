package tree.avl;

public interface MyAVLTree {

    int size();

    boolean isEmpty();

    void add(int val);

    void remove(int val);

    boolean contains(int val);
}
