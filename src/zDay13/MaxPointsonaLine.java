package zDay13;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 149. Max Points on a Line
 * @author: Zekun Zhang
 * @create: 2020-02-26 11:07
 */

public class MaxPointsonaLine {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{0,0},{94911151,94911150},{94911152,94911151}};
        maxPoints(arr);
    }

    public static int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int res = 1;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int same = 1, maxThisRound = 0, verti = 1;
            int[] point1 = points[i];
            String str1 = Integer.toString(point1[0]) + "," + Integer.toString(point1[1]);
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int[] point2 = points[j];
                    String str2 = Integer.toString(point2[0]) + "," + Integer.toString(point2[1]);
                    if (str1.equals(str2)) {
                        same++;
                        continue;
                    }
                    if (point2[0] == point1[0]) {
                        verti++;
                        continue;
                    }
                    int y = point2[1] - point1[1];
                    int x = point2[0] - point1[0];
                    int dev = gcd(x, y);
                    String k = y / dev + "/" + x / dev;
                    int cur = map.getOrDefault(k, 0) + 1;
                    map.put(k, cur);
                    maxThisRound = Math.max(cur, maxThisRound);
                }
            }
            res = Math.max(Math.max(verti, res), maxThisRound + same);
        }
        return res;
    }

    private static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
