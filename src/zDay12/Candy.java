package zDay12;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: LeetForWork
 * @description: 135. Candy
 * @author: Zekun Zhang
 * @create: 2020-02-25 21:36
 */

public class Candy {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.print(rand.nextInt(10) + ",");
        }
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]) {
                arr[i] = arr[i + 1] + 1;
            }
        }

        int res = 0;
        for (int num : arr) {
            res += num;
        }
        return res;
    }
}
