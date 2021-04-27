package com.hxcoder.complete.easy.fiveHundredNine;

/**
 * @author hxcoder
 */
public class SolutionTwoCorrect {

    public static void main(String[] args) {


    }

    public int lib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int first = 0, second = 1, result = -1;
        for (int i = 0; i < n - 1; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
