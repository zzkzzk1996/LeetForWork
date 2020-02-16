package zDay08;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 379. Design Phone Directory
 * @author: Zekun Zhang
 * @create: 2020-02-16 07:59
 */

public class DesignPhoneDirectory {

    private Queue<Integer> queue;
    private HashMap<Integer, Boolean> map;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        queue = new LinkedList<>();
        map = new HashMap<>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
            map.put(i, true);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Integer num = queue.isEmpty() ? null : queue.poll();
        if (num != null) map.put(num, false);
        return num == null ? -1 : num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return map.get(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (map.get(number) == null || map.get(number)) return;
        queue.offer(number);
        map.put(number, true);
    }
}
