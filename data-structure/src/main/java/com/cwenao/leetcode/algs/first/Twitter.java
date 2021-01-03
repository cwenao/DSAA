/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id DesignTwitter.java, v1.0.0 2021-01-02 14:28 cwenao Exp $$
 */
public class Twitter {

    private Integer timestamp = 0;

    private Map<Integer, User> userMap = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return result;
        }
        Set<Integer> followed = userMap.get(userId).followed;

        Queue<Tweet> priorityQueue = new PriorityQueue<Tweet>(followed.size(),(a,b)-> {
            return b.timestamp.compareTo( a.timestamp);
        });

        for (Integer followUserId : followed) {
            Tweet tweetHead = userMap.get(followUserId).head;
            if (tweetHead == null) {
                continue;
            }
            priorityQueue.add(tweetHead);
        }

        while (!priorityQueue.isEmpty()) {
            if (result.size() >= 10) {
                return result;
            }
            Tweet currentTweet = priorityQueue.poll();
            result.add(currentTweet.id);
            if (currentTweet.next != null) {
                priorityQueue.add(currentTweet.next);
            }
        }

        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));

        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }

    class Tweet{
        private Integer id;
        private Long timestamp;
        private Tweet next;

        public Tweet(Integer id, Long timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    class User{
        private Integer id;
        public Set<Integer> followed;
        public Tweet head;

        public User(Integer id) {
            this.id = id;
            this.head = null;
            this.followed = new HashSet<>();
            follow(id);
        }

        public void follow(Integer userId) {
            followed.add(userId);
        }

        public void unfollow(Integer userId) {
            if (followed.contains(userId) && !this.id.equals(userId)) {
                followed.remove(userId);
            }
        }

        public void post(Integer tweetId) {
            Tweet tweet = new Tweet(tweetId, new Date().getTime());
            tweet.next = head;
            head = tweet;
        }

    }

}
