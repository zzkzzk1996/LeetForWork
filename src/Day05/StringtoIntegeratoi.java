package Day05;

/**
 * @program: LeetForWork
 * @description: 8. String to Integer (atoi)
 * @author: Zekun Zhang
 * @create: 2019-09-05 21:46
 */

public class StringtoIntegeratoi {
    public static int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int start = 0;
        long res = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
            start++;
        } else if (str.charAt(0) == '+') {
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                break;
            }
            res = res * 10 + (str.charAt(i) - '0');
            if (res > Integer.MAX_VALUE && sign == 1) {
                return Integer.MAX_VALUE;
            }
            if (res > Integer.MAX_VALUE && sign == -1) {
                return Integer.MIN_VALUE;
            }
        }
        res *= sign;
        return (int)res;
    }
    public static void main(String[] args) {
        int res = myAtoi("9223372036854775808");
    }
}
