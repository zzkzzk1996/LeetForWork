package zDay13;

/**
 * @program: LeetForWork
 * @description: 157. Read N Characters Given Read4
 * @author: Zekun Zhang
 * @create: 2020-02-26 17:34
 */

public class ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int index = 0;
        while (true) {
            int count = read4(temp);
            count = Math.min(count, n - index);
            for (int i = 0; i < count; i++) {
                buf[index++] = temp[i];
            }
            if (index == n || count < 4) return index;
        }
    }
    private int read4(char[] c) {
        return 0;
    }
}
