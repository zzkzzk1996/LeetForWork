package Day79;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 379. Design Phone Directory
 * @author: Zekun Zhang
 * @create: 2020-01-14 19:13
 */

public class DesignPhoneDirectory {

    Queue<Integer> queue;
    HashSet<Integer> set;
    int maxNumber;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        this.queue = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
        this.set = new HashSet<>();
        this.maxNumber = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!queue.isEmpty()) {
            Integer number = queue.poll();
            set.add(number);
            return number;
        } else return -1;
        // Integer number = queue.poll();
        // if (number == null) return -1;
        // set.add(number);
        // return number;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= maxNumber || number < 0)
            return false;
        return !set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (set.remove(number)) {
            queue.offer(number);
        }
    }
}
