package com.hxcoder.complete.easy.fiveHundredNine;

/**
 * 509.斐波那契数
 * 要求：
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和
 * 请计算 F(n)
 * <p>
 * 提示：
 * 0 <= n <= 30
 * <p>
 * 解题思路：
 * 1.递归
 * 2.迭代
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
        int test = 4;
        Solution s = new Solution();
        System.out.println(s.fib(test));
    }

    public int fib(int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
