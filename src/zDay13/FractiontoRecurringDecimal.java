package zDay13;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 166. Fraction to Recurring Decimal
 * @author: Zekun Zhang
 * @create: 2020-02-27 11:54
 */

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) sb.append("-");
        long x = Math.abs(Long.valueOf(denominator));
        long y = Math.abs(Long.valueOf(numerator));
        sb.append(String.valueOf(y / x));
        long remainder = y % x;
        if (remainder == 0) return sb.toString();
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(String.valueOf(remainder / x));
            remainder %= x;
        }
        return sb.toString();
    }
}
