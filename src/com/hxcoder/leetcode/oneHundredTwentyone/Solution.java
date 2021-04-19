package com.hxcoder.leetcode.oneHundredTwentyone;

/**
 * 121.买卖股票的最佳时机
 * 解决方法：
 * 1.暴力解法：遍历数组，存储每一天的利润，然后在去除最大利润（存在两次循环，所以效率低）
 * 2.动态规划，对暴力解法进行优化，可以对重复子问题去重
 * 3.一次遍历，先记录历史最低价格，然后继续遍历，用当前价格减去最低价格，记录最高收益，最后返回（理解：题目中存在两个变化的状态——最低价格，最高收益）
 * <p>
 * 错误：超出时间限制——错误原因：就算使用了动态规划，还是出现了两层循环，遍历了所有数据两边，所以导致了时间复杂度为n的平方，动态规划使用错误，退化为暴力遍历求解
 * 解决方法：由于错误的建立了动态规划模型，所以导致了没有充分利用dp备忘录的特性，没有减少子问题的数量——也就是两层循环，规模没有减少。——>解决方法：利用备忘录特性，改为一层循环
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
        int[] test = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(test));
    }

    /**
     * 动态规划——1.首先明确状态是什么——也就是现在能够获得的最大利润 2.明确选择是什么——今天要不要进行卖出和买入  3.写出状态转移方程  4.择优选取
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 构造dp数组
        int[] dp = new int[prices.length];
        int profit = 0;
        int max = dp[0];
        // 根据prices生成dp数组的内容
        // 动态规划本质——>dp数组——>暴力解法的优化
        // 对三种情况进行择优——1.今天卖出 2.昨天卖出 3.明天卖出 ——>优化为  今天的利润依赖于昨天的利润  ——> 动态规划的本质——>使用dp数组记录重复子问题的结果，从而实现优化
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // 表示做出今天卖出的选择
                profit = prices[j] - prices[i];
                // 表示今天做出选择和今天不做出选择的比较
                dp[j] = Math.max(profit, dp[j]);
                if (dp[j] > max) {
                    max = dp[j];
                }
            }
        }
        return max;
    }
}
