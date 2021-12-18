package com.geekidentity.leetcode.offerII;

/**
 * 动态规划
 * 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class Offer42MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int sum = nums[0], max = sum;
        for (int i = 1; i < nums.length; i++) {
            int d = nums[i];
            if (sum <= 0) {
                sum = d;
            } else {
                sum += d;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
