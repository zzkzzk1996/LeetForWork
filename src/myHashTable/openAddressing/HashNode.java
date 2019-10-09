package myHashTable.openAddressing;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-08 20:42
 */

public class HashNode<K, V> {
    public K key;

    public V value;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
