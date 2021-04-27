package com.hxcoder.complete.medium.sevenHundredFour;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target
 * 搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 * <p>
 * 提示：
 * nums 中的所有元素是不重复的
 * n 将在 [1, 10000]之间
 * nums 的每个元素都将在 [-9999, 9999]之间
 * <p>
 * 解题思路：使用二分搜索
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid, midVal;
        while (left <= right) {
            mid = left + (right - left) / 2;
            midVal = nums[mid];
            if (target == midVal) {
                return mid;
            }
            if (target < midVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
