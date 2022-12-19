// https://leetcode.com/problems/design-twitter/

import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int a, int b) {
        first = a;
        second = b;
    }
}
class Twitter {

    HashMap<Integer,HashSet<Integer>> follow   = new HashMap<>();
    HashMap<Integer,List<Pair>> posts = new HashMap<>();
    int time = 0;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        posts.putIfAbsent(userId, new ArrayList<>());
        if (!follow.containsKey(userId)) follow.put(userId, new HashSet<>());
        follow.get(userId).add(userId);
        posts.get(userId).add(new Pair(time, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!follow.containsKey(userId)) return new LinkedList<>();
        PriorityQueue<Pair> feed = new PriorityQueue<>((t1, t2) -> t2.first - t1.first);
        follow.get(userId).stream()
            .filter(f -> posts.containsKey(f))
            .forEach(f -> posts.get(f).forEach(feed::add));
        List<Integer> res = new LinkedList<>();
        while (feed.size() > 0 && res.size() < 10) res.add(feed.poll().second);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId)) follow.put(followerId, new HashSet<>());
        follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId) && followeeId != followerId) follow.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */