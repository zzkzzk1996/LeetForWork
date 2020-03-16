package zDay22;

/**
 * @program: LeetForWork
 * @description: 42. Trapping Rain Water
 * @author: Zekun Zhang
 * @create: 2020-03-14 21:14
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
