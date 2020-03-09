package zDay18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 269. Alien Dictionary
 * @author: Zekun Zhang
 * @create: 2020-03-05 11:45
 */

public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        int count = 0;
        int[] degree = new int[26];
        for (String word : words) {
            for (Character c : word.toCharArray()) {
                if (degree[c - 'a'] == 0) {
                    degree[c - 'a'] = 1;
                    count++;
                }
            }
        }

        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    if (!map.containsKey(words[i].charAt(j))) {
                        map.put(words[i].charAt(j), new HashSet<>());
                    }

                    if (map.get(words[i].charAt(j)).add(words[i + 1].charAt(j))) {
                        degree[words[i + 1].charAt(j) - 'a']++;
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 1) {
                queue.offer((char)(i + 'a'));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (map.containsKey(c)) {
                for (char ch : map.get(c)) {
                    if (--degree[ch - 'a'] == 1) queue.offer(ch);
                }
            }
        }

        if (sb.length() != count) return "";
        return sb.toString();
    }
}
