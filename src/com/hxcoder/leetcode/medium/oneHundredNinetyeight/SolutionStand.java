package com.hxcoder.leetcode.medium.oneHundredNinetyeight;

/**
 * 收获：
 * 1.注意：理解动态规划的核心思想——消除重复子问题——由子状态组成原状态——
 * 也就是对于状态转移方程的写法不必拘束于dp[状态][选择]——而是直接dp[状态]
 *
 * @author hxcoder
 */
public class SolutionStand {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
