package zDay08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @program: LeetForWork
 * @description: 380. Insert Delete GetRandom O(1)
 * @author: Zekun Zhang
 * @create: 2020-02-16 12:22
 */

public class InsertDeleteGetRandomO1 {

    private Random rand;
    private HashMap<Integer, Integer> map; /** key : nums, val : pos */
    private List<Integer> list;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        rand = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        } else return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            if (map.get(val) == list.size() - 1) {
                map.remove(val);
            } else {
                int lastNum = list.get(list.size() - 1);
                list.set(map.get(val), lastNum);
                map.put(lastNum, map.get(val));
                map.remove(val);
            }
            list.remove(list.size() - 1);
            return true;
        } else return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randPos = rand.nextInt(list.size());
        return list.get(randPos);
    }
}
