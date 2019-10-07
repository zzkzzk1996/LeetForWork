package Day36;

/**
 * @program: LeetForWork
 * @description: 12. Integer to Roman
 * @author: Zekun Zhang
 * @create: 2019-10-06 23:46
 */

public class IntegertoRoman {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        String[] symbols = new String[]{"I", "V", "X", "L", "C", "D", "M"};
        for (int i = 0; i < 4; i++) {
            int bit = num % 10;
            if (bit < 4) {
                for (int j = 0; j < bit; j++) {
                    res.append(symbols[i*2]);
                }
            } else if (bit == 4) {
                res.append(symbols[i*2 + 1]).append(symbols[i*2]);
            } else if (bit < 9) {
                for (int j = 0; j < bit - 5; j++) {
                    res.append(symbols[i*2]);
                }
                res.append(symbols[i*2 + 1]);
            } else {
                res.append(symbols[i*2 + 2]).append(symbols[i*2]);
            }
            num /= 10;
            if (num == 0) break;
        }
        return res.reverse().toString();
    }
    public String intToRoman1(int num) {
        StringBuilder res = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res.append(symbols[i]);
            }
        }
        return res.toString();
    }

}
