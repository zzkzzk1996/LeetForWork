package Day02;

/**
 * @program: LeetForWork
 * @description: 201. Bitwise AND of Numbers Range
 * @author: Zekun Zhang
 * @create: 2019-09-02 14:19
 */

public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int countBit = 0;
        while (m != n) {
            countBit++;
            m >>= 1;
            n >>= 1;
        }
        return m << countBit;
    }
}
