package com.hxcoder.leetcode.easy.nine;

/**
 * @author hxcoder
 */
public class SolutionStand {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }
}
