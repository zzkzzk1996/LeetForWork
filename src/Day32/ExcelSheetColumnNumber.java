package Day32;

/**
 * @program: LeetForWork
 * @description: 171. Excel Sheet Column Number
 * @author: Zekun Zhang
 * @create: 2019-10-02 23:56
 */

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }
}
