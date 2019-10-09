package myHashTable.separateChaining;

import myHashTable.myHashTable;
import myHashTable.separateChaining.implementation.HashTableSeparateChaining;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-08 20:07
 */

public class Main {
    public static void main(String[] args) {
        myHashTable<Integer, Integer> hashTable = new HashTableSeparateChaining<>();
        hashTable.put(1, 1);
        hashTable.put(11, 1);
        hashTable.put(21, 1);
        hashTable.put(12, 1);
        hashTable.put(22, 1);
        hashTable.print();
        hashTable.delete(21);
        hashTable.print();
    }
}
