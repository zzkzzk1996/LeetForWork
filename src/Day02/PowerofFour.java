package Day02;

/**
 * @program: LeetForWork
 * @description: 342. Power of Four
 * @author: Zekun Zhang
 * @create: 2019-09-02 14:55
 */

public class PowerofFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        if ((num & (num - 1)) == 0) {
            while(num > 1) {
                num >>= 2;
            }
            if (num == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isPowerOfFour1(int num) {
        return (Math.log(num) / Math.log(4.0)) % 1 == 0;
    }
}
