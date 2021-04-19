package com.hxcoder.leetcode.oneHundredTwentyone;

/**
 * 收获：
 * 1.对于像Integer.MAX_VALUE这种特殊值的选择，要从相反的角度去选择，并且一定要集合题目中实际的数据范围
 * 2.这种解法相当于双指针，程序中的for循环使得prices的遍历方向只能是从左向右，然后右指针指向最低价格，左指针指向每天的价格，两者相减就是最低的，防止出现才小的，所以需要存储变量值
 * 3.对于涉及到有两个状态改变，一般使用双指针法进行解题
 *
 * @author hxcoder
 */
public class SolutionImproveOne {
    public static void main(String[] args) {
        int[] test = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(test));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if ((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
