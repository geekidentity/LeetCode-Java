package com.geekidentity.leetcode.n0011;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {

    /**
     * 暴力方法
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }

    /**
     * 双指针法
     */
    public int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j++];
            int area = minHeight * (j - i + 1);
            if (area > maxArea) maxArea = area;
        }
        return maxArea;
    }
}
