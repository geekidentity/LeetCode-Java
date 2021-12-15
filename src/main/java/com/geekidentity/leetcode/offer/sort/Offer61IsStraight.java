package com.geekidentity.leetcode.offer.sort;

import java.util.HashSet;
import java.util.Set;

/**
 * 排序
 * 剑指 Offer 61. 扑克牌中的顺子
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class Offer61IsStraight {
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length < 5) {
            return false;
        }
        int min = 14, max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i == 0) continue;
            if (set.contains(i)) return false;
            if (i < min) min = i;
            if (i > max) max = i;
            set.add(i);
        }
        return max - min < 5;
    }
}
