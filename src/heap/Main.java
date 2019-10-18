package heap;

import heap.implementation.MyMaxHeapImplementation;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-17 17:29
 */

public class Main {
    public static void main(String[] args) {
        MyMaxHeap<Integer> myMaxHeap = new MyMaxHeapImplementation<>();
        Integer[] nums = new Integer[]{2, 23, 30, 8, 32, 31, 41, 1, 15};
        for (Integer num : nums) {
            myMaxHeap.offer(num);
        }
        myMaxHeap.print();
    }
}
