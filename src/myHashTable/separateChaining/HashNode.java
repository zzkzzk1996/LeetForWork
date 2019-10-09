package myHashTable.separateChaining;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-08 19:43
 */

public class HashNode<K, V> {

    public K key;

    public V value;

    public HashNode next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
