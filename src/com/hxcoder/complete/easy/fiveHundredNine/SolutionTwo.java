package com.hxcoder.complete.easy.fiveHundredNine;

/**
 * 使用迭代解决斐波那契数列
 * <p>
 * 错误：
 * 原因：
 * 1.对于细节，没有进行细致考虑，只是凭借着经验，进行大体建模
 * 2.对于程序流程，没有很好的建模
 * 3.递归写法转换为非递归写法不熟练
 *
 * @author hxcoder
 */
public class SolutionTwo {

    public static void main(String[] args) {
        int test = 3;
        SolutionTwo s = new SolutionTwo();
        System.out.println(s.fib(test));
    }

    public int fib(int n) {
        int first = 0, second = 1, result = 0;
        for (int i = 0; i < n; i++) {
            // 注意：这里应该是先加后移动
            result = second + first;
            // 滚动窗口技巧
            first = second;
            second = second + first;
        }
        return result;
    }
}
