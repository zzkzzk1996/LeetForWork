package Day14;

/**
 * @program: LeetForWork
 * @description: 75. Sort Colors
 * @author: Zekun Zhang
 * @create: 2019-09-14 23:47
 */

public class SortColors {
    public void sortColors(int[] nums) {
        int cur1 = 0, cur2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(cur1++, i, nums);
            } else if (nums[i] == 2 && cur2 >= i) {
                swap(cur2--, i-- ,nums);
            }
        }
    }

    public void sortColors1(int[] nums) {
        int cur1 = 0, cur2 = nums.length - 1, index = 0;
        while (index <= cur2) {
            if (nums[index] == 0) {
                swap(index++, cur1++, nums);
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(index, cur2--, nums);
            }
        }

    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
