package zDay07;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 359. Logger Rate Limiter
 * @author: Zekun Zhang
 * @create: 2020-02-14 12:51
 */

public class LoggerRateLimiter {
    private HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        this.map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            if (Math.abs(map.get(message) - timestamp) < 10) return false;
        }
        map.put(message, timestamp);
        return true;
    }
}
