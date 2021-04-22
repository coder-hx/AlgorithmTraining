package com.hxcoder.leetcode.hard.oneHundredTwentyone;

/**
 * @author hxcoder
 */
public class SolutionImprove {

    public static void main(String[] args) {
        int[] test = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(test));
    }

    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int profit;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - prices[i - 1];
            // ！！！错误：相当于一只股票被卖了两次
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + profit);
            if (dp[i] > maxProfit) {
                maxProfit = dp[i];
            }
        }
        return maxProfit;
    }
}