package Day29;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 394. Decode String
 * @author: Zekun Zhang
 * @create: 2019-09-29 18:51
 */

//TODO IMPORTANT

public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() < 2) return s;
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                countStack.push(num);
            } else if (c == '[') {
                stringStack.push(res);
                res = "";
            } else if (c == ']') {
                int time = countStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for (int j = 0; j < time; j++) {
                    temp.append(res);
                }
                res = temp.toString();

//                int time = countStack.pop();
//                String temp = res;
//                for (int j = 1; j < time; j++) {
//                    res += temp;
//                }
//                res = stringStack.pop() + res;
            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }
}
