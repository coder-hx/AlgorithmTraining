package com.hxcoder.leetcode.sevenHundredThirtynine;

import java.util.Stack;

/**
 * 使用单调栈进行优化
 *
 * @author hxcoder
 */
public class SolutionStackImprove {

    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        SolutionStackImprove s = new SolutionStackImprove();
        int[] result = s.dailyTemperatures(temperatures);
        for (int el :
                result) {
            System.out.println(el);
        }

    }

    /**
     * 出现错误，由于对于最后的结果理解不够清楚，所以导致了单纯采用计数的方法来获取两个元素之间的距离，但是由于存在多个元素之间的关系，所以导致处理极其麻烦
     * 改进建议：单调栈存储中的每个元素的小标，然后距离就是下标只差
     * 对于程序中各个变量的作用区分不清，所以导致编写混乱
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < T.length; i++) {
            count = 0;
            while (!stack.isEmpty()) {
                int temp = stack.peek();
                if (temp < T[i]) {
                    stack.pop();
                    count++;
                    result[i - count] = count;
                } else {
                    break;
                }
            }
            if (count == 1) {
                count = 0;
            }
            stack.add(T[i]);
        }
        return result;
    }
}