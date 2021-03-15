package com.eltobeski.LeetCode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    Map<Integer, Integer> cache;
    int size;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.size = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
        if (cache.size() == size) {
            Iterator<Integer> iterator = cache.keySet().iterator();
            int leastKey = iterator.next();
            cache.remove(leastKey);
        }

        cache.put(key, value);
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}