package zDay07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 244. Shortest Word Distance II
 * @author: Zekun Zhang
 * @create: 2020-02-14 13:42
 */

public class ShortestWordDistanceII {
    private HashMap<String, List<Integer>> map;
    public ShortestWordDistanceII(String[] words) {
        this.map = new HashMap<>();
        for (int i = 0 ; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                List<Integer> list = map.get(words[i]);
                list.add(i);
                map.put(words[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0, minPath = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                minPath = Math.min(minPath, list2.get(j) - list1.get(i));
                i++;
            } else {
                minPath = Math.min(minPath, list2.get(j) - list1.get(i));
                j++;
            }
        }
        return minPath;
    }
}
