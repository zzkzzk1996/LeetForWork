package Day13;

/**
 * @program: LeetForWork
 * @description: 11. Container With Most Water
 * @author: Zekun Zhang
 * @create: 2019-09-13 08:53
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int left = 0, right = height.length - 1, res = 0;;
        while (left < right) {
            if (height[left] < height[right]) {
                res = Math.max(res, (height[left] * (right - left)));
                left++;
            } else {
                res = Math.max(res, (height[right] * (right - left)));
                right--;
            }
        }
        return res;
    }
}
