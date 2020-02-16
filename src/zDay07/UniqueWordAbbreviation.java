package zDay07;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: LeetForWork
 * @description: 288. Unique Word Abbreviation
 * @author: Zekun Zhang
 * @create: 2020-02-14 12:59
 */

public class UniqueWordAbbreviation {
    /**
     * HashMap nested HashSet
     */
//    private HashMap<String, HashSet<String>> map;
//    public UniqueWordAbbreviation(String[] dictionary) {
//        this.map = new HashMap<>();
//        for (String word : dictionary) {
//            String abbr = wordBuilder(word);
//            if (abbr != null) {
//                if (map.containsKey(abbr)) {
//                    HashSet<String> set = map.get(abbr);
//                    set.add(word);
//                    map.put(abbr, set);
//                } else {
//                    HashSet<String> set = new HashSet<>();
//                    set.add(word);
//                    map.put(abbr, set);
//                }
//            }
//        }
//    }
//
//    private String wordBuilder(String word) {
//        if (word == null) return null;
//        if (word.length() < 3) return word;
//        String abbr = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
//        return abbr;
//    }
//
//    public boolean isUnique(String word) {
//        String abbr = wordBuilder(word);
//        if (abbr == null) return false;
//        if (!map.containsKey(abbr)) return true;
//        else {
//            if (map.get(abbr).size() > 1) return false;
//            else{
//                return map.get(abbr).contains(word);
//            }
//        }
//    }


    private HashMap<String, String> map;
    public UniqueWordAbbreviation(String[] dictionary) {
        this.map = new HashMap<>();
        for (String word : dictionary) {
            String abbr = wordBuilder(word);
            if (abbr != null) {
                if (map.containsKey(abbr)) {
                    if (!map.get(abbr).equals(word)) {
                        map.put(abbr, "");
                    }
                } else {
                    map.put(abbr, word);
                }
            }
        }
    }

    private String wordBuilder(String word) {
        if (word == null) return null;
        if (word.length() < 3) return word;
        String abbr = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
        return abbr;
    }

    public boolean isUnique(String word) {
        String abbr = wordBuilder(word);
        if (abbr == null) return false;
        return (!map.containsKey(abbr) || map.get(abbr).equals(word));
    }
}
