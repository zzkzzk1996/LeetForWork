package Day05;

/**
 * @program: LeetForWork
 * @description: 258. Add Digits
 * @author: Zekun Zhang
 * @create: 2019-09-05 23:34
 */

public class AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public int addDigits1(int num) {
         while (num >= 10) {
             int temp = num;
             int sum = 0;
             while (temp != 0) {
                 sum += temp % 10;
                 temp /= 10;
             }
             num = sum;
         }
         return num;
    }

    public int addDigits2(int num) {
         int sum = 0;
         while (num != 0) {
             sum += num % 10;
             num /= 10;
         }
         if (sum >= 10) {
             return addDigits(sum);
         } else {
             return sum;
         }
    }

    public int addDigits3(int num) {
         String numStr = Integer.toString(num);
         while (numStr.length() > 1) {
             String temp = numStr;
             int sum = 0;
             for (int i = 0; i < numStr.length(); i++) {
                 sum += (numStr.charAt(i) - '0');
             }
             numStr = Integer.toString(sum);
         }
         return Integer.parseInt(numStr);
    }
}
