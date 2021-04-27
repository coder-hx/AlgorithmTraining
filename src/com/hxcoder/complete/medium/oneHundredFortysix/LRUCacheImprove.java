package com.hxcoder.complete.medium.oneHundredFortysix;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 利用Java自带LinkedHashMap数据结构
 * <p>
 * 收获：
 * 1.Java提供的标准数据结构——LinkedHashMap就是LinkedList和HashMap的结合，LinkedList保证插入顺序，hashMap表示随机访问
 * 2.new LinkedHashMap(capacity,loadFactor,accessOrder：所有Entity按照访问顺序进行访问)
 */
public class LRUCacheImprove {

    int capacity;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCacheImprove(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
