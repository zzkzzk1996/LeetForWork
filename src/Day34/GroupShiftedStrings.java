package Day34;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 249. Group Shifted Strings
 * @author: Zekun Zhang
 * @create: 2019-10-04 23:43
 */

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = "";
            char[] ch = s.toCharArray();
            StringBuilder temp = new StringBuilder("");
            for (int i = 1; i < ch.length; i++) {
                int bias = ch[i] - ch[i - 1];
                bias = bias < 0 ? bias + 26 : bias;
                temp.append(String.valueOf(bias) + ",");
                key = temp.toString();
            }
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
