package zDay10;

/**
 * @program: LeetForWork
 * @description: 167. Two Sum II - Input array is sorted
 * @author: Zekun Zhang
 * @create: 2020-02-20 18:16
 */

public class TwoSumIIInputarrayissorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[] {-1, -1};
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] {i + 1, j + 1};
            } else if (sum < target) i++;
            else j--;
        }
        return new int[] {-1, -1};
    }
}
