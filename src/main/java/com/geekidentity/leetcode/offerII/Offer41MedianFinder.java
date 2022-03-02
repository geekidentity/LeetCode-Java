package com.geekidentity.leetcode.offerII;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 排序
 * 剑指 Offer 41. 数据流中的中位数
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 */
public class Offer41MedianFinder {
    private final Queue<Integer> minHeap = new PriorityQueue<>();
    private final Queue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));

    /** initialize your data structure here. */
    public Offer41MedianFinder() {

    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) return (minHeap.peek() + maxHeap.peek()) / 2.0;
        else return maxHeap.peek();
    }
}
