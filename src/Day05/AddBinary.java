package Day05;

/**
 * @program: LeetForWork
 * @description: 67. Add Binary
 * @author: Zekun Zhang
 * @create: 2019-09-05 23:00
 */

public class AddBinary {
    public static String addBinary(String a, String b) {
        String res = "";
        int m = a.length();
        int n = b.length();
        int i = m - 1;
        int j = n - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int temp = carry;
            if (i >= 0) temp += (a.charAt(i) - '0');
            if (j >= 0) temp += (b.charAt(j) - '0');
            if (temp > 1) {
                carry = 1;
                temp -= 2;
            } else {
                carry = 0;
            }
            res = Integer.toString(temp) + res;
            i--;
            j--;
        }
        if (carry == 1) {
            res = "1" + res;
        }
        return res;
    }
    public static void main(String[] args) {
        String res = addBinary("100", "110010");
    }
}
