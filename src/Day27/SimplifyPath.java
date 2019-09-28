package Day27;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 71. Simplify Path
 * @author: Zekun Zhang
 * @create: 2019-09-27 13:01
 */

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "";
        String[] temp = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (String s : temp) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) return "/";
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res;
    }
}
