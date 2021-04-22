package com.hxcoder.leetcode.medium.oneHundredNinetyeight;

/**
 * 198. 打家劫舍
 * 要求：
 * 两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
 * 给定一个代表每个房屋存放金额的非负整数数组，计算不触动警报装置的情况下，一夜之内能够偷窃到的最高金额
 * <p>
 * 提示:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * 解题思路:
 * 1.使用动态规划，由于后面的状态依赖于前面的状态，而且具有相同结构的子问题，所以具有多阶段解答的结构————>动态规划
 * 状态：偷到的金额   选择：偷/不偷  限制：不能偷相邻的————>dp[i][1]/dp[i][0]
 * base case:
 * dp[0][0]=0
 * dp[0][1]=nums[0]
 * dp[1][0]=nums[0]
 * dp[1][1]=nums[1]
 * 状态转移方程：
 * dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
 * dp[i][1]=dp[i-1][0]+nums[i];
 * 最后结果：
 * Math.max(dp[i-1][0],dp[i-1][1])
 * <p>
 * 收获：注意动态规划中的状态转移方程，各个状态的表示，因为各个状态都设计到与前面的状态有关，所以一定要明确状态之间的分界
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.rob(test));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums[0];
        }
        int[][] dp = new int[len][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[0];
        dp[1][1] = nums[1];

        // 状态转移
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
