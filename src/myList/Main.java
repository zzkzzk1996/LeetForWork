package myList;

import myList.arrayList.implementation.ArrayListImplementation;
import myList.linkedList.MyLinkedList;
import myList.linkedList.implementation.LinkedListImplementation;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-10 10:41
 */

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new LinkedListImplementation<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.print();
        list.add(0, 100);
        list.print();
    }
}
