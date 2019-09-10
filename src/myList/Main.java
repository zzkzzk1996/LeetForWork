package myList;

import myList.implementation.ArrayListImplementation;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-10 10:41
 */

public class Main {
    public static void main(String[] args) {
        ArrayListImplementation arrayList = new ArrayListImplementation();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(0, 0);
        arrayList.remove(3);
        arrayList.removeElement(1);
        arrayList.print();
        System.out.println(arrayList.get(0));
    }
}
