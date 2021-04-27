package com.hxcoder.complete.medium.oneHundredTwentyone;

/**
 * 动态规划解决股票问题
 *
 * @author hxcoder
 */
public class SolutionImproveTwo {

    public static void main(String[] args) {
        int[] test = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(test));
    }

    /**
     * 使用动态规划的递推方式，从base case推导出最后的结果
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        // DP数组
        // int[][] dp = new int[len][2];

        // base
        // dp[0][0] = 0;
        // dp[0][1] = -prices[0];

        int dp0_0 = 0;
        int dp0_1 = -prices[0];

        // 进行递推，构造出dp[n][0]——也即是在第N天的时候，最大利润
        for (int i = 1; i < len; i++) {
            // 状态转移方程
            // 注意：一定要明确：动态规划的核心就是穷举所有状态，然后择优不同的选择更新状态，最后递推到最后的结果
            // 由于当i=0时，dp数组下标越界，代入特殊值后发现dp[i][0]和dp[i - 1][0]等价
            // dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            // dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);

            dp0_0 = Math.max(dp0_1 + prices[i], dp0_0);
            dp0_1 = Math.max(-prices[i], dp0_1);

        }
        return dp0_0;
    }
}
