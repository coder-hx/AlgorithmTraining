package com.hxcoder.leetcode.hard.twoHundredFifteen;

import java.util.Arrays;

/**
 * TopK问题：解题思路一般是使用堆排序，但是为了方便，也可以直接使用Java Arrays.sort()中的快排，然后逆序找到第len-k个位置，就是需要找的元素
 *
 * @author hxcoder
 */
public class SolutionImprove {

    public static void main(String[] args) {
        int[] arrs = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(arrs, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}