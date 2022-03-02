package com.geekidentity.leetcode.offerII;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 排序
 * 剑指 Offer 40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class Offer40GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }

        Queue<Integer> maxStack = new PriorityQueue<>((a, b) -> b - a);
        for (int i : arr) {
            if (maxStack.size() < k) {
                maxStack.offer(i);
            } else if (!maxStack.isEmpty() && maxStack.peek() > i) {
                maxStack.poll();
                maxStack.offer(i);
            }
        }
        int[] result = new int[maxStack.size()];
        int i = 0;
        for (Integer n : maxStack) {
            result[i++] = n;
        }
        return result;
    }
}
