package Day29;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 388. Longest Absolute File Path
 * @author: Zekun Zhang
 * @create: 2019-09-29 18:18
 */

//TODO AGAIN

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }
}
