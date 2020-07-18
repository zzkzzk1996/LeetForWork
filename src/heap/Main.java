package heap;

import heap.implementation.MyMaxHeapImplementation;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-17 17:29
 */

public class Main {
    public static void main(String[] args) {
//        MyMaxHeap<Integer> myMaxHeap = new MyMaxHeapImplementation<>();
//        Integer[] nums = new Integer[]{2, 23, 30, 8, 32, 31, 41, 1, 15};
//        for (Integer num : nums) {
//            myMaxHeap.offer(num);
//        }
//        myMaxHeap.print();
        compare1();
        compare2();
    }

    public static void compare1() {
        int[] nums = new int[]{1, 2, 3, 4};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Integer num : nums) {
            priorityQueue.offer(num);
        }
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    public static void compare2() {
        int[] nums = new int[]{1, 2, 3, 4};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Integer num : nums) {
            priorityQueue.offer(num);
        }
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    public static void compare3() {
        int[] nums = new int[]{1, 2, 3, 4};
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>((a, b) -> (a.a - b.a));
    }

    class Node {
        int a;
        int b;
    }
}
