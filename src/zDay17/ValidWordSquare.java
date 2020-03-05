package zDay17;

import java.util.List;

/**
 * @program: LeetForWork
 * @description: 422. Valid Word Square
 * @author: Zekun Zhang
 * @create: 2020-03-03 22:04
 */

public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) return true;
        if (words.get(0).length() != words.size()) return false;
        for (int i = 0; i < words.get(0).length(); i++)  {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.size(); j++) {
                if (words.get(j).length() > i) sb.append(words.get(j).charAt(i));
            }
            String str = sb.toString();
            if (!str.equals(words.get(i))) return false;
        }
        return true;
    }
}
