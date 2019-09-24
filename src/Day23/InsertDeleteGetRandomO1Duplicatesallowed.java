package Day23;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * @author: Zekun Zhang
 * @create: 2019-09-23 23:50
 */

public class InsertDeleteGetRandomO1Duplicatesallowed {
    List<Integer> list;
    HashMap<Integer, HashSet<Integer>> map;
    Random rand;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1Duplicatesallowed() {
        this.list = new ArrayList<>();
        this.rand = new Random();
        this.map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !map.containsKey(val);
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            HashSet<Integer> set = map.get(val);
            int index = map.get(val).iterator().next();
            map.get(val).remove(index);
            if (map.get(val).size() == 0) map.remove(val);
            int value = list.remove(list.size() - 1);
            if (index != list.size()) {
                list.set(index, value);
                map.get(value).remove(list.size());
                map.get(value).add(index);
            }
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
