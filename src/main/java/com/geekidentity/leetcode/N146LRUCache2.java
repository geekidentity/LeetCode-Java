package com.geekidentity.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class N146LRUCache2 {
    static class LinkedNode {
        int key;
        int value;
        LinkedNode previous;
        LinkedNode next;
        public LinkedNode() {}
        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private int size;
    private final LinkedNode first;
    private final LinkedNode last;
    private final Map<Integer, LinkedNode> cache;

    public N146LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        first = new LinkedNode();
        last = new LinkedNode();
        first.next = last;
        last.previous = first;
    }

    public int get (int key) {
        LinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            node = new LinkedNode(key, value);
            if (size + 1 > capacity) {
                LinkedNode removeNode = removeTail();
                cache.remove(removeNode.key);
            } else {
                size++;
            }
            cache.put(key, node);
            addHead(node);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addHead(node);
    }

    private LinkedNode removeTail() {
        LinkedNode node = last.previous;
        removeNode(node);
        return node;
    }

    private void removeNode(LinkedNode node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void addHead(LinkedNode node) {
        node.next = first.next;
        node.previous = first;
        first.next.previous = node;
        first.next = node;
    }
}
