package zDay16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @program: LeetForWork
 * @description: 380. Insert Delete GetRandom O(1)
 * @author: Zekun Zhang
 * @create: 2020-03-03 15:13
 */

public class InsertDeleteGetRandomO1 {

    List<Integer> list;
    HashMap<Integer, Integer> map;
    Random rand;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            if (map.get(val) != list.size() - 1) {
                map.put(list.get(list.size() - 1), map.get(val));
                list.set(map.get(val), list.get(list.size() - 1));
            }
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
