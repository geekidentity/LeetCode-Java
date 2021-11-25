package com.geekidentity.leetcode.offer.search;

/**
 * 查找算法
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Offer53Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int number = 0;
        int first = getFirstK(nums, target, 0, nums.length - 1);
        int last = getLastK(nums, target, 0, nums.length - 1);
        if (first > -1 && last > -1) {
            number = last - first + 1;
        }
        return number;
    }

    private int getFirstK(int[] nums, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = nums[middleIndex];
        if (middleData == k) {
            if ((middleIndex > 0 && nums[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstK(nums, k, start, end);
    }

    private int getLastK(int[] nums, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = nums[middleIndex];
        if (middleData == k) {
            if ((middleIndex == nums.length - 1) || (middleIndex < nums.length - 1 && nums[middleIndex + 1] !=k)) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getLastK(nums, k, start, end);
    }

    public static void main(String[] args) {
        Offer53Search search = new Offer53Search();
        //test1(search);
        test2(search);

    }

    private static void test2(Offer53Search search) {
        int[] nums1 = {5,7};
        int target = 5;
        System.out.println(search.search(nums1, target));
    }

    private static void test1(Offer53Search search) {
        // expect result is 2
        int[] nums1 = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(search.search(nums1, target));
    }
}
