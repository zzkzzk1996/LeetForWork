package tree.rbTree;

import java.util.Map;
import java.util.TreeMap;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-12-01 14:44
 */

public class TreeMapTest {

    public static void main(String[] args) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(1, 5);
        map.put(5, 5);
        map.put(2, 5);
        map.put(4, 5);

        System.out.println(map.ceilingKey(3));
        System.out.println(map.floorKey(3));

        System.out.println(map.higherKey(3));
        System.out.println(map.lowerKey(3));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }

    }
}
