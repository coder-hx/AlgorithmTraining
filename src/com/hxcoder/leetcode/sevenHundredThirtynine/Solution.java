package com.hxcoder.leetcode.sevenHundredThirtynine;

/**
 * 739. 每日温度
 * 要求：
 * 根据每日 气温 列表，重新生成一个列表。
 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替
 * <p>
 * 提示：
 * 气温 列表长度的范围是 [1, 30000]
 * 每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数
 * <p>
 * 解题思路：
 * 1.暴力枚举：使用双指针进行两次遍历，统计以前一个指针为基准，后一个指针移动几次才会刚好大于前一个元素，时间复杂度为n的平方
 * 2.进阶解法：由于暴力解法会导致多遍历一遍元素，所以考虑改进时间复杂度，采用空间换时间，由于遍历是具有方向的，
 * 所以只能使用栈来进行模拟，存储之间已经遍历过的元素，防止冗余遍历————>使用单调栈————>使用场景：寻找后面的元素比前面大的元素，同时遍历的方向固定
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {


    }

    /**
     * 暴力遍历
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int count = 0;
            for (int j = i + 1; j < T.length; j++) {
                count++;
                if (T[i] < T[j]) {
                    result[i] = count;
                    break;
                }
            }
        }
        return result;
    }
}
