package zDay11;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 68. Text Justification
 * @author: Zekun Zhang
 * @create: 2020-02-21 21:04
 */

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int intervals = last - index - 1;
            if (last == words.length || intervals == 0) {
                for (int i = index + 1; i < last; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }

                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / intervals;
                int rest = (maxWidth - count) % intervals;
                for (int i = index + 1; i < last; i++) {
                    for (int k = spaces; k > 0; k--) {
                        sb.append(" ");
                    }
                    if (rest > 0) {
                        sb.append(" ");
                        rest--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            index = last;
            res.add(sb.toString());
        }
        return res;
    }
}
