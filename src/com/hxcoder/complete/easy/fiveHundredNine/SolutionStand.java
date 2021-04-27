package com.hxcoder.complete.easy.fiveHundredNine;

/**
 * 收获：
 * 1.给定n，循环n次，可以使用while( n-- >0 )
 * 2.双指针——滑动窗口，滑动代码一般只有三行，多了说明可以进行优化
 *
 * @author hxcoder
 */
public class SolutionStand {

    public static void main(String[] args) {

    }

    public int fib(int n) {
        int first = 0;
        int second = 1;
        while (n-- > 0) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return first;
    }
}
