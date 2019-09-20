package Day19;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: LeetForWork
 * @description: 349. Intersection of Two Arrays
 * @author: Zekun Zhang
 * @create: 2019-09-19 22:09
 */

public class IntersectionofTwoArrays {
    /**
     * time: O(NlogN)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int[] res = new int[set.size()];
        int k = 0;
        for (int num : set) {
            res[k++] = num;
        }
        return res;
    }
    private boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    /**
     * time: O(NlogN)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) j++;
            else i++;
        }
        int[] res = new int[set.size()];
        int k = 0;
        for (int num : set) {
            res[k++] = num;
        }
        return res;
    }

    /**
     * time: O(N)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ret = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                ret.add(num);
            }
        }
        int[] res = new int[ret.size()];
        int k = 0;
        for (int num : ret) {
            res[k++] = num;
        }
        return res;
    }


}
