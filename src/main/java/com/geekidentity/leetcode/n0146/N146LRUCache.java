package com.geekidentity.leetcode.n0146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * 最简单的解法
 */
public class N146LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public N146LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    public V get(Object key) {
        return super.get(key);
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
