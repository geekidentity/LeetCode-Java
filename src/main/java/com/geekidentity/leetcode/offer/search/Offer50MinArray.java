package com.geekidentity.leetcode.offer.search;

/**
 * 查找算法
 * 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class Offer50MinArray {

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int left = 0, right = numbers.length - 1, middle = left;
        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                return numbers[right];
            }
            // 如果下标为left, right, middle指向的三个数字相等，则只能顺序查找
            if (numbers[left] == numbers[right] && numbers[left] == numbers[middle]) {
                return minInOrder(numbers, left, right);
            }
            middle = (left + right) / 2;
            if (numbers[middle] >= numbers[left]) {
                left = middle;
            } else if (numbers[middle] <= numbers[right]) {
                right = middle;
            }
        }
        return numbers[middle];
    }

    private int minInOrder(int[] numbers, int left, int right) {
        int result = numbers[left];
        for (int i = left + 1; i <= right; i++) {
            if (numbers[i] < result) {
                result = numbers[i];
            }
        }
        return result;
    }
}
