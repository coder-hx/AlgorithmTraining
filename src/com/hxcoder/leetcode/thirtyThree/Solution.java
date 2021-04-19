package com.hxcoder.leetcode.thirtyThree;

/**
 * 33.搜索旋转排序数组
 * 要求：
 * 整数数组 nums 按升序排列，数组中的值 互不相同
 * 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1
 * 旋转示例：[0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2]
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 * <p>
 * 进阶：
 * 设计一个时间复杂度为 O(log n) 的解决方案
 * <p>
 * 解题思路：
 * 1.由于需要时间复杂度是lg，所以算法的基本逻辑就是二分 ———> 使用二分搜索
 * <p>
 * 错误：基本逻辑错误：单纯的根据target和left/right进行移动左右指针，而没有考虑实际上的mid，所以导致错误
 * 改正方法：由于原数组是经过旋转之后的，所以前一部分一定比后一部分总体上大，所以先根据target和left/right的大小关系，找到合适的查找范围，然后在具体的范围中进行二分查找
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        Solution s = new Solution();
        System.out.println(s.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        int leftIdx = 0;
        int rightIdx = len - 1;
        int left = nums[leftIdx];
        int right = nums[rightIdx];

        while (leftIdx < rightIdx) {
            int tempIdx = (leftIdx + rightIdx + 1) / 2;
            int temp = nums[tempIdx];
            if (target == temp) {
                return tempIdx;
            }
            if (target == left) {
                return leftIdx;
            }
            if (target == right) {
                return rightIdx;
            }
            if (target > right) {
                rightIdx = tempIdx;
            } else {
                leftIdx = tempIdx;
            }
        }
        return -1;
    }
}
