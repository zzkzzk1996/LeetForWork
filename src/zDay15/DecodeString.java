package zDay15;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 394. Decode String
 * @author: Zekun Zhang
 * @create: 2020-03-02 11:44
 */

public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() < 2) return s;
        Stack<Integer> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i + 1;
                while (Character.isDigit(s.charAt(j))) j++;
                stack1.push(Integer.parseInt(s.substring(i, j)));
                i = j - 1;
            } else if (c == '[') {
                stack2.push(res);
                res = "";
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(stack2.pop());
                int time = stack1.pop();
                for (int j = 0; j < time; j++) {
                    temp.append(res);
                }
                res = temp.toString();

            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }
}
