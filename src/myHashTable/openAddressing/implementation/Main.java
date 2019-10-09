package myHashTable.openAddressing.implementation;

import myHashTable.myHashTable;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-08 21:05
 */

public class Main {
    public static void main(String[] args) {
        myHashTable<Integer, Integer> hashTable = new HashTableOpenAddressing<>();
        hashTable.put(1, 1);
        hashTable.put(11, 1);
        hashTable.put(21, 1);
        hashTable.put(31, 1);
        hashTable.put(42, 1);
        hashTable.print();
        hashTable.put(45, 1);
        hashTable.delete(21);
        hashTable.print();
    }
}
