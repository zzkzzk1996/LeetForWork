package Day32;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-02 23:47
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder("");
        while (n > 0) {
            n--;
            res.append((char)('A' + n % 26));
            n /= 26;
        }
        return res.reverse().toString();
    }
}
