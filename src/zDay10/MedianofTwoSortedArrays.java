package zDay10;

/**
 * @program: LeetForWork
 * @description: 4. Median of Two Sorted Arrays
 * @author: Zekun Zhang
 * @create: 2020-02-20 13:23
 */

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /** exchange nums1 and nums2 to make sure the short one is nums1 */
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int len = nums1.length + nums2.length;
        int cut1 = 0, cut2 = 0, cutL = 0, cutR = nums1.length;
        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) cutR = cut1 - 1;
            else if (L2 > R1) cutL = cut1 + 1;
            else {
                if (len % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.min(R1, R2);
                }
            }
        }
        return -1;
    }
}
