package Day35;

/**
 * @program: LeetForWork
 * @description: 38. Count and Say
 * @author: Zekun Zhang
 * @create: 2019-10-05 23:12
 */

public class CountandSay {
    public String countAndSay(int n) {
        String res = "1";
        String temp = "";
        for (int i = 1; i < n; i++){
            int count = 0;
            for (int j = 0; j < res.length(); j++) {
                count++;
                if (j == res.length() - 1 || res.charAt(j + 1) != res.charAt(j)) {
                    temp += String.valueOf(count) + String.valueOf(res.charAt(j));
                    count = 0;
                }
            }
            res = temp;
            temp = "";
        }
        return res;
    }
}
