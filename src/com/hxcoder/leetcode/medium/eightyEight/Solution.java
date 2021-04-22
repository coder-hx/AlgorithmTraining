package com.hxcoder.leetcode.medium.eightyEight;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 要求：
 * 两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素
 * <p>
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * <p>
 * 解题思路：
 * 1.直接使用Java提供的API，先使用num2对num1进行填充，再进行排序
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, nums2.length);
        Arrays.sort(nums1);
    }
}
