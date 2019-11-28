package tree.binarySearchTree;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-28 17:19
 */

public interface MyBinarySearchTree {

    void add(int val);

    void remove(int val);

    boolean contains(int val);

    int size();

    boolean isEmpty();
}
