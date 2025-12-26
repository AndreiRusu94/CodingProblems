package third;
/*
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed
or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.


Example 1:

Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem355 {
    public static void main(String[] args) {
        Solution355 solution = new Solution355();

        Solution355.Twitter twitter = solution.new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}

class Solution355 {

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */

    class Twitter {

        private static int timeStamp = 0;
        private final Map<Integer, List<Tweet>> tweetMap;
        private final Map<Integer, Set<Integer>> followMap;

        private record Tweet(int tweetId, int time) {
        }

        public Twitter() {
            followMap = new HashMap<>();
            tweetMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweetMap.putIfAbsent(userId, new ArrayList<>());
            tweetMap.get(userId).add(new Tweet(tweetId, timeStamp++));
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
            if (tweetMap.containsKey(userId)) {
                for (Tweet tweet : tweetMap.get(userId)) {
                    maxHeap.offer(tweet);
                }
            }

            Set<Integer> followees = followMap.getOrDefault(userId, Collections.emptySet());

            for (int followeeId : followees) {
                if (tweetMap.containsKey(followeeId)) {
                    for (Tweet tweet : tweetMap.get(followeeId)) {
                        maxHeap.offer(tweet);
                    }
                }
            }

            List<Integer> newsFeed = new ArrayList<>();
            while (!maxHeap.isEmpty() && newsFeed.size() < 10) {
                newsFeed.add(maxHeap.poll().tweetId);
            }

            return newsFeed;
        }

        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) return;

            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followMap.containsKey(followerId)) {
                followMap.get(followerId).remove(followeeId);
            }
        }
    }

}

