package com.hxcoder.leetcode.medium.thirtyThree;

/**
 * 错误：
 * 错误原因：对于二分查找，在特殊情况下，对于循环条件+midIdx的取值，有可能会导致死循环的处理方法不熟
 *
 * @author hxcoder
 */
public class SolutionCorrect {

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 4;
        SolutionCorrect s = new SolutionCorrect();
        System.out.println(s.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int numsLen = nums.length;
        if (numsLen == 1) {
            return target == nums[0] ? 0 : -1;
        }

        int leftIdx = 0;
        int rightIdx = numsLen - 1;
        int left = nums[leftIdx];
        int right = nums[rightIdx];

        // 如果target就是边上就直接进行返回
        if (target == left) {
            return 0;
        }
        if (target == right) {
            return numsLen - 1;
        }

        // 先找到合适的查找范围
        // target 在数组的左边
        if (target > nums[numsLen - 1]) {
            while (target > right) {
                rightIdx = (rightIdx + leftIdx) / 2;
                right = nums[rightIdx];
                if (right > nums[numsLen - 1]) {
                    break;
                }
            }
            // 矫正位置
            while (nums[rightIdx] < nums[rightIdx + 1]) {
                ++rightIdx;
            }
        }

        // target在数组的右边
        if (target < nums[numsLen - 1]) {
            while (left > right) {
                leftIdx = (leftIdx + rightIdx) / 2;
                left = nums[leftIdx];
            }
            // 矫正位置
            while (leftIdx > 1 && nums[leftIdx] > nums[leftIdx - 1]) {
                --leftIdx;
            }
        }

        // 此时leftIdx和rightIdx都处于正确范围的边界，再对这个范围进行二分查找
        // target刚好在边界
        if (target == nums[leftIdx]) {
            return leftIdx;
        }
        if (target == nums[rightIdx]) {
            return rightIdx;
        }

        // target 不在这个范围中
        if (target > nums[rightIdx] || target < nums[leftIdx]) {
            return -1;
        }


        int midIdx;
        int mid;
        while (leftIdx < rightIdx) {
            midIdx = (leftIdx + rightIdx) / 2;
            mid = nums[midIdx];

            if (target == mid) {
                return midIdx;
            }
            if (target > mid) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx - 1;
            }
        }
        return -1;
    }
}
