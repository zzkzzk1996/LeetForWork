package Day09;

/**
 * @program: LeetForWork
 * @description: 360. Sort Transformed Array
 * @author: Zekun Zhang
 * @create: 2019-09-09 14:58
 */

//TODO TOO LONG

public class SortTransformedArray {
    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int[] res = new int[n];
        if (a == 0) {
            if (b >= 0) {
                for (int i = 0; i < res.length; i++) {
                    res[i] = func(nums[i], a, b, c);
                }
            } else {
                for (int i = res.length - 1; i >= 0; i--) {
                    res[i] = func(nums[res.length - i - 1], a, b, c);
                }
            }
        } else {
            int k = b / (2 * a) * (-1);
            int cur = 0;
            if (((nums[0] >= k) && (a > 0)) || ((nums[n - 1] <= k) && (a < 0))) {
                for (int i = 0; i < res.length; i++) {
                    res[i] = func(nums[i], a, b, c);
                }
            } else if (((nums[0] >= k) && (a < 0)) || ((nums[n - 1] <= k) && (a > 0))) {
                for (int i = n - 1; i >= 0; i--) {
                    res[i] = func(nums[i], a, b, c);
                }
            } else {
                while (cur < n && nums[cur] < k) cur++;
                int i = cur - 1, j = cur;
                for (int z = 0; z < n; z++) {
                    if (i >= 0 && j <= n - 1) {
                        int resi = func(nums[i], a, b, c);
                        int resj = func(nums[j], a, b, c);
                        if (a > 0) {
                            res[z] = Math.min(resi, resj);
                            if (resi < resj) {
                                i--;
                            } else {
                                j++;
                            }
                        } else {
                            res[n - z - 1] = Math.max(resi, resj);
                            if (resi < resj) {
                                j++;
                            } else {
                                i--;
                            }
                        }
                    } else if (i >= 0 && j > n - 1) {
                        int resi = func(nums[i], a, b, c);
                        if (a > 0) {
                            res[z] = resi;
                        } else {
                            res[n - z - 1] = resi;
                        }
                        i--;
                    } else if (i < 0 && j <= n - 1) {
                        int resj = func(nums[j], a, b, c);
                        if (a > 0) {
                            res[z] = resj;
                        } else {
                            res[n - z - 1] = resj;
                        }
                        j++;
                    }
                }
            }
        }
        return res;
    }
    private static int func(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public static void main(String[] args) {
        int[] k = new int[] {-4,-2,2,4};
        int[] res = new int[k.length];
        res = sortTransformedArray(k, 1, 3, 5);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
