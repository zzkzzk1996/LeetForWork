package zDay19;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 658. Find K Closest Elements
 * @author: Zekun Zhang
 * @create: 2020-03-08 16:27
 */

public class FindKClosestElements {
    /**
     * TreeSet
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) return new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (res.size() < k) {
            int numLeft = set.floor(x) == null ? Integer.MIN_VALUE : set.floor(x);
            int numRight = set.ceiling(x) == null ? Integer.MAX_VALUE : set.ceiling(x);
            int num = numRight;
            if ((long)x - numLeft <= (long)numRight - x) {
                res.addFirst(numLeft);
                num = numLeft;
            } else {
                res.add(numRight);
            }

            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    set.remove(num);
                }
                map.put(num, map.get(num) - 1);
            }
        }
        return res;
    }

    /**
     * Sort
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) return new ArrayList<>();
//        MyComparator myComparator = new MyComparator();
//        Arrays.sort(arr, myComparator);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

//    class MyComparator implements Comparator<Integer> {
//        @Override
//        public int compare(Integer a, Integer b) {
//            return Math.abs(a - x) - Math.abs(b - x);
//        }
//    }

    /**
     * BinarySearch
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) return new ArrayList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
        } else if (x > arr[arr.length - 1]) {
            for (int i = arr.length - 1 - k; i < arr.length - 1; i++) {
                res.add(arr[i]);
            }
        } else {
            int index = binarySearch(arr, 0, arr.length - 1, x);
            int countLeft = 0, countRight = 1;
            while (res.size() < k) {
                int leftDiff = index - countLeft < 0 ? Integer.MAX_VALUE : x - arr[index - countLeft];
                int rightDiff = index + countRight > arr.length - 1 ? Integer.MAX_VALUE : arr[index + countRight] - x;
                if (leftDiff <= rightDiff) {
                    res.addFirst(arr[index - countLeft]);
                    countLeft++;
                } else {
                    res.add(arr[index + countRight]);
                    countRight++;
                }
            }

        }
        return res;
    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
