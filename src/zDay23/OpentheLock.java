package zDay23;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 752. Open the Lock
 * @author: Zekun Zhang
 * @create: 2020-03-16 22:42
 */

public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }
        Queue<String> queue = new LinkedList<>();
        if (set.contains("0000")) return -1;
        queue.offer("0000");
        visited.add("0000");
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String cur = queue.poll();
                if (cur.equals(target)) return steps;
                else {
                    for (int i = 0; i < 4; i++) {
                        for (int j = -1; j <= 1; j += 2) {
                            int change = ((cur.charAt(i) - '0') + j + 10) % 10;
                            String newTry = cur.substring(0, i) + ("" + change) + cur.substring(i + 1);
                            if (!visited.contains(newTry) && !set.contains(newTry)) {
                                queue.offer(newTry);
                                visited.add(newTry);
                            }
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
