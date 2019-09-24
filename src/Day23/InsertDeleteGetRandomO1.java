package Day23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @program: LeetForWork
 * @description: 380. Insert Delete GetRandom O(1)
 * @author: Zekun Zhang
 * @create: 2019-09-23 17:34
 */

public class InsertDeleteGetRandomO1 {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    Random rand;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        this.rand = new Random();
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.remove(val);
            int value = list.remove(list.size() - 1);
            if (index != list.size()) {
                list.set(index, value);
                map.put(value, index);
            }
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
