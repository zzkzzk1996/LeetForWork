package Day16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 244. Shortest Word Distance II
 * @author: Zekun Zhang
 * @create: 2019-09-16 23:27
 */

public class ShortestWordDistanceII {
    private HashMap<String, List<Integer>> map;

    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        int count = 0;
        for (String word : words) {
            if (!map.containsKey(word)) {
                List<Integer> list = new ArrayList<>();
                list.add(count++);
                map.put(word, list);
            } else {
                map.get(word).add(count++);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE, i1 = 0, i2 = 0;
        while (i1 < list1.size() && i2 < list2.size()) {
            int w1 = list1.get(i1), w2 = list2.get(i2);
            if (w1 <= w2) {
                res = Math.min(res, (w2 - w1));
                i1++;
            } else {
                res = Math.min(res, (w1 - w2));
                i2++;
            }
        }
        return res;
    }
}
