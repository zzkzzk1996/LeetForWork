package Day08;

/**
 * @program: LeetForWork
 * @description: 306. Additive Number
 * @author: Zekun Zhang
 * @create: 2019-09-08 22:12
 */

//TODO AGAIN

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        for (int i = 1; i <= (num.length() - 1) / 2; i++) {
            for (int j = 1; Math.max(i, j) <= num.length() - i - j; j++) {
                if (isValid(i, j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        if (num.charAt(i) == '0' && j > 1) return false;
        if (num.charAt(0) == '0' && i > 1) return false;
        String sum = "";
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x1 + x2;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}
