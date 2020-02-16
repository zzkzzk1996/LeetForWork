package zDay08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @program: LeetForWork
 * @description: 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * @author: Zekun Zhang
 * @create: 2020-02-16 15:40
 */

public class InsertDeleteGetRandomO1Duplicatesallowed {

    private Random rand;
    private List<Integer> list;
    private HashMap<Integer, List<Integer>> map;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1Duplicatesallowed() {
        this.rand = new Random();
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new ArrayList<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !map.containsKey(val);
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int lastNum = list.get(list.size() - 1);
            if (val == lastNum) {
                map.get(val).remove(map.get(val).indexOf(list.size() - 1));
                if (map.get(val).size() == 0) {
                    map.remove(val);
                }
            } else {
                List<Integer> pos = map.get(val);
                int valPos = pos.remove(pos.size() - 1);
                if (pos.size() == 0) {
                    map.remove(val);
                }

                List<Integer> lastPos = map.get(lastNum);
                int indexLastPos = lastPos.indexOf(list.size() - 1);

                lastPos.set(indexLastPos, valPos);
                list.set(valPos, lastNum);
            }
            list.remove(list.size() - 1);
            return true;
        } else return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
