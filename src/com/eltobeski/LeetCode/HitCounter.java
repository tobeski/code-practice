package com.eltobeski.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class HitCounter {
            Queue<Integer> q;

    /** Initialize your data structure here. */
    public HitCounter() {
        q = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
           while (!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }

    public static void main(String[] args){
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        hitCounter.getHits(4);
        // hit at timestamp 300.
        hitCounter.hit(300);

// get hits at timestamp 300, should return 4.
        hitCounter.getHits(300);

// get hits at timestamp 301, should return 3.
        hitCounter.getHits(301);
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

