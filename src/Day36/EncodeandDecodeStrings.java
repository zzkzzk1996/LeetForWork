package Day36;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 271. Encode and Decode Strings
 * @author: Zekun Zhang
 * @create: 2019-10-06 21:31
 */

//TODO AGAIN

public class EncodeandDecodeStrings {
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder res = new StringBuilder();
            for (String str : strs) {
                res.append(str.length()).append("/").append(str);
            }
            return res.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> res = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int slash = s.indexOf("/", i);
                int size = Integer.valueOf(s.substring(i, slash));
                i = slash + 1 + size;
                res.add(s.substring(slash + 1, i));
            }
            return res;
        }
    }
}
