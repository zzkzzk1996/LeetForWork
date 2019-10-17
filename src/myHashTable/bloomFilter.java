package myHashTable;

import java.util.BitSet;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-17 13:42
 */

public class bloomFilter {
    private static final int DEFAULT_SIZE = 1 << 25;

    private BitSet bitSet = new BitSet(DEFAULT_SIZE);

    private static final int[] seed = new int[]{5, 7, 11, 13, 41, 61};

    private HashFunction[] hashFunctions = new HashFunction[seed.length];

    public static class HashFunction {
        private int capacity;
        private int seed;

        public HashFunction(int capacity, int seed) {
            this.capacity = capacity;
            this.seed = seed;
        }

        public int hash(String value) {
            int res = 0;
            for (int i = 0; i < value.length(); i++) {
                res = res * seed + value.charAt(i);
            }
            return (capacity - 1) & res;
        }
    }

    public bloomFilter() {
        for (int i = 0; i < seed.length; i++) {
            hashFunctions[i] = new HashFunction(DEFAULT_SIZE, seed[i]);
        }
    }

    public void add(String value) {
        for (HashFunction hashFunction : hashFunctions) {
            bitSet.set(hashFunction.hash(value), true);
        }
    }

    public boolean contains(String value) {
        if (value == null) return false;
        boolean res = true;

        for (HashFunction hashFunction : hashFunctions) {
            res = res && bitSet.get(hashFunction.hash(value));
        }
        return res;
    }

    public static void main(String[] args) {
        String value = "test";
        bloomFilter bloomFilter = new bloomFilter();
        boolean res = bloomFilter.contains(value);
        System.out.println(res);
        bloomFilter.add(value);
        res = bloomFilter.contains(value);
        System.out.println(res);
    }
}
