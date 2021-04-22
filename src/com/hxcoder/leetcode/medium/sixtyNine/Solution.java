package com.hxcoder.leetcode.medium.sixtyNine;

/**
 * 69.x 的平方根
 * 要求：
 * 实现 int sqrt(int x) 函数
 * 计算并返回 x 的平方根，其中 x 是非负整数
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去
 * <p>
 * 解题思路：
 * 1.相当于寻找边界————> a的平方<x<b的平方 ————> 需要找出a ————> 所以使用二分算法
 * <p>
 * 错误：
 * 原因：对于二分搜索连续区间边界代码写法不熟悉，直接写成了二分搜索具体的值的代码
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int mid;
        int midVal = 0;

        while (left < right) {
            mid = left + (right - left) / 2;
            midVal = mid * mid;
            if (midVal == x) {
                break;
            }
            if (midVal < x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return midVal;
    }
}
