package com.hxcoder.complete.easy.twoHundredEightythree;

/**
 * 双指针思想，代码改进
 *
 * @author hxcoder
 */
public class SolutionImprove {

    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        // 注意：如果循环中出现nums.length，需要对其提到循环之间用一个变量进行表示，这样可以减少空间复杂度
        int left = 0, right = 0, len = nums.length;
        while (right < len) {
            if (nums[right] != 0) {
                exchange(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void exchange(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
