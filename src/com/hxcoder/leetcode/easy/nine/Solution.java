package com.hxcoder.leetcode.easy.nine;

/**
 * 9.回文数
 * 要求：
 * 一个整数 x，如果 x 是一个回文整数，返回 true；否则，返回 false
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * <p>
 * 提示：
 * -2的31次方 <= x <= 2的31次方 - 1
 * <p>
 * 进阶：
 * 不能将整数转为字符串
 * <p>
 * 解题思路：
 * 1.直接使用Java内置API，先转换为字符串，然后逆序之后，和原来的字符串进行比较，相同就是回文串
 * 2.直接使用双指针技巧，从两边向中间，逐个进行比较 ————> 使用取模和除法来取得对应的数值
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

        int x = 121;
        Solution s = new Solution();
        System.out.println(s.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        // 错误：
        // 错误原因：new StringBuilder(int x)，相当于构造一个容量为x的字符数组
        // StringBuilder s = new StringBuilder(x);
        String origin = String.valueOf(x);
        String reverse = new StringBuilder(origin).reverse().toString();
        return origin.equals(reverse);
    }
}
