package zDay09;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 355. Design Twitter
 * @author: Zekun Zhang
 * @create: 2020-02-16 22:52
 */

public class DesignTwitter {
    private int timeStamp;
    private HashMap<Integer, User> userMap;

    class Tweet {
        public int id;
        private int time;
        public Tweet next;
        public Tweet(int id) {
            this.id = id;
            next = null;
            this.time = timeStamp++;
        }
    }

    class User {
        private int id;
        public HashSet<Integer> follows;
        public Tweet head;
        public User(int id) {
            this.id = id;
            follows = new HashSet<>();
            /**
             * this step is really important
             */
            follow(id);
            head = null;
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = head;
            head = t;
        }

        public void follow(int followId) {
            follows.add(followId);
        }

        public void unfollow(int followId) {
            follows.remove(followId);
        }
    }

    /** Initialize your data structure here. */
    public DesignTwitter() {
        this.userMap = new HashMap<>();
        this.timeStamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        HashSet<Integer> followers = userMap.get(userId).follows;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(followers.size(), (a, b) -> (b.time - a.time));
        for (int follower : followers) {
            Tweet t = userMap.get(follower).head;
            if (t != null) {
                pq.offer(t);
            }
        }

        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet temp = pq.poll();
            if (temp.next != null) {
                pq.offer(temp.next);
            }
            res.add(temp.id);
            count++;
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User follower = new User(followerId);
            userMap.put(followerId, follower);
        }

        if (!userMap.containsKey(followeeId)) {
            User followee = new User(followeeId);
            userMap.put(followeeId, followee);
        }

        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId || !userMap.containsKey(followerId)) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}
