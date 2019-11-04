package Day64;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 358. Rearrange String k Distance Apart
 * @author: Zekun Zhang
 * @create: 2019-11-03 20:57
 */

public class RearrangeStringkDistanceApart {
    public static String rearrangeString(String s, int k) {
        if (k >= s.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
//        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
//        Queue<Character> valid = new LinkedList<>();
//        pq.addAll(map.keySet());
//        StringBuilder sb = new StringBuilder("");
//        while (!pq.isEmpty()) {
//            Character c = pq.poll();
//            sb.append(c);
//            map.put(c, map.get(c) - 1);
//            valid.offer(c);
//            if (valid.size() < k) continue;
//            Character t = valid.poll();
//            if (map.get(t) > 0) {
//                pq.offer(t);
//            }
//        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        pq.addAll(map.entrySet());
        Queue<Map.Entry<Character, Integer>> valid = new LinkedList<>();
        StringBuilder sb = new StringBuilder("");
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            sb.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            valid.offer(cur);
            if (valid.size() < k) continue;
            Map.Entry<Character, Integer> temp = valid.poll();
            if (temp.getValue() > 0) {
                pq.offer(temp);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
