package myHashTable.openAddressing.implementation;

import myHashTable.myHashTable;
import myHashTable.openAddressing.HashNode;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-08 20:43
 */

public class HashTableOpenAddressing<K, V> implements myHashTable<K, V> {
    private HashNode[] hashNodes;

    private int capacity;

    private int size;

    public HashTableOpenAddressing() {
        this.capacity = 5;
        hashNodes = new HashNode[capacity];
    }

    public HashTableOpenAddressing(int capacity) {
        this.capacity = capacity;
        hashNodes = new HashNode[capacity];
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        int startIndex = index;
        while (hashNodes[index] != null) {
            if (hashNodes[index].key.equals(key)) {
                hashNodes[index].value = value;
                return;
            }
            ++index;
            index %= capacity;
            if (index == startIndex) {
                resize();
                index = hash(key);
                startIndex = index;
            }
        }
        hashNodes[index] = new HashNode(key, value);
        size++;
    }

    private void resize() {
        capacity *= 2;
        HashNode[] oldHashNodes = hashNodes;
        hashNodes = new HashNode[capacity];
        size = 0;
        for (int i = 0; i < oldHashNodes.length; i++) {
            if (oldHashNodes[i] != null) {
                put((K) oldHashNodes[i].key, (V) oldHashNodes[i].value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        while (hashNodes[index] != null) {
            if (hashNodes[index].key.equals(key)) {
                return (V) hashNodes[index].value;
            }
            ++index;
            index %= capacity;
        }
        return null;
    }

    @Override
    public V delete(K key) {
        int index = hash(key);
        while (hashNodes[index] != null) {
            if (hashNodes[index].key.equals(key)) {
                V temp = (V) hashNodes[index].value;
                hashNodes[index] = null;
                size--;
                return temp;
            }
            ++index;
            index %= capacity;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        for (HashNode<K, V> hashNode : hashNodes) {
            if (hashNode != null) {
                System.out.println(" key : " + hashNode.key + " value : " + hashNode.value);
            }
        }
        System.out.println("size : " + size);
        System.out.println("capacity : " + capacity);
    }
}
