package zDay08;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 281. Zigzag Iterator
 * @author: Zekun Zhang
 * @create: 2020-02-15 18:44
 */

public class ZigzagIterator {
    /**
     * Queue
     */
//    private Queue<Integer> queue;
//    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//        queue = new LinkedList<>();
//        int i = 0, j = 0;
//        while (i < v1.size() || j < v2.size()) {
//            if (i < v1.size()) {
//                queue.offer(v1.get(i++));
//            }
//            if (j < v2.size()) {
//                queue.offer(v2.get(j++));
//            }
//        }
//    }
//
//    public int next() {
//        return queue.poll();
//    }
//
//    public boolean hasNext() {
//        return !queue.isEmpty();
//    }

    private Iterator<Integer> i, j, temp;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        j = v1.iterator();
        i = v2.iterator();
    }

    public int next() {
        if (j.hasNext()) {
            temp = j;
            j = i;
            i = temp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }

    /**
     * LinkedList contains iterator
     */
//    private LinkedList<Iterator> list;
//    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//        list = new LinkedList<>();
//        if (!v1.isEmpty()) list.add(v1.iterator());
//        if (!v2.isEmpty()) list.add(v2.iterator());
//    }
//
//    public int next() {
//        Iterator poll = list.remove();
//        int result = (Integer) poll.next();
//        if (poll.hasNext()) list.add(poll);
//        return result;
//    }
//
//    public boolean hasNext() {
//        return !list.isEmpty();
//    }
}
