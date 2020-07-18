package AlgorithmForCourse;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2020-03-11 16:54
 */

public class huawei2 {
    private static int res = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] cors = new int[5][2];
        int n = 0;
        while (scan.hasNextInt() && n < 10) {
            cors[n / 2][n % 2] = scan.nextInt();
            n++;
        }
//        int[][] cors = new int[][] {
//                {200, 0},
//                {200, 10},
//                {200, 50},
//                {200, 30},
//                {200, 25}
//        }
        int[] start = new int[]{0, 0};
        while (set.size() < 5) {
            start = helper(cors, start);
        }
        int dist = (int)Math.sqrt(Math.pow((start[0]), 2) + (int)Math.pow((start[1]), 2));
        res += dist;
        System.out.println(res);
    }
    private static HashSet<int[]> set = new HashSet<>();


    private static int[] helper(int[][] cors, int[] start) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < cors.length; i++) {
            int[] temp = cors[i];
            if (temp == start || set.contains(temp)) continue;
            int dist = (int)Math.sqrt(Math.pow((temp[0] - start[0]), 2) + Math.pow((temp[1] - start[1]), 2));
            if (min > dist) {
                min = dist;
                minIndex = i;
            }
        }
        if (min == Integer.MAX_VALUE) return new int[]{0, 0};
        res += min;
        set.add(cors[minIndex]);
        return cors[minIndex];
    }
}
