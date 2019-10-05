package Day34;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 290. Word Pattern
 * @author: Zekun Zhang
 * @create: 2019-10-04 23:33
 */

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split("\\s+");
        if (words.length != pattern.length()) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) return false;
            } else {
                if (!map.containsValue(words[i])){
                    map.put(c, words[i]);
                } else return false;
            }
        }
        return true;
    }
}
