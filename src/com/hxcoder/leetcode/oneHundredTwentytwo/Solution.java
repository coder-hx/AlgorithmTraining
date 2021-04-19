package com.hxcoder.leetcode.oneHundredTwentytwo;

/**
 * 122. 买卖股票的最佳时机 II
 * 要求：
 * 尽可能地完成更多的交易（多次买卖一支股票），计算所能获取的最大利润
 * 不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * <p>
 * 解题思路：
 * 1.该问题具有阶段性求解的性质，最后的状态依赖前面的状态，同时具有重叠子问题————>使用动态规划
 * 2.分析状态：股票持有情况  当前最大获利
 * 3.分析base case：int dp[1/0][1/0]=最大获利  dp[i][1]：表示当前持有股票  dp[i][0]：表示当前不持有股票
 * ——>dp[0][1]=Integer.MIN   dp[0][0]=0  dp[1][0]=0  dp[1][1]=-price[1]
 * 4.分析状态转移方程：
 * dp[i][1]=dp[i-1][1]+dp[i-1][0]-prices[i]
 * dp[i][0]=dp[i-1][0]+dp[i-1][1]+prices[i]
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        //base case
        dp[1][1] = -prices[0];
        dp[1][0] = 0;
        dp[0][1] = 0;
        dp[0][0] = 0;
        // 难点：由于可以多次交易，所以对于最后的结果而言，前一天的状态依赖性并不是很强，所以整体状态方程该怎么写？？？
        for (int i = 1; i <= prices.length; i++) {
            // 状态转移
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + prices[i - 1];
            dp[i][1] = dp[i - 1][1] + dp[i - 1][0] - prices[i - 1];
        }
        return dp[prices.length - 1][0];
    }
}