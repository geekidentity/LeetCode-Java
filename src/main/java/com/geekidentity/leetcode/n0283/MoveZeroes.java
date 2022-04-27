package com.geekidentity.leetcode.n0283;

import com.geekidentity.leetcode.utils.ArrayUtils;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) ArrayUtils.swap(nums, i, j++);
        }
    }
}
