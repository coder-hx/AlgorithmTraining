package com.hxcoder.complete.medium.sevenHundredThirtynine;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 对原有单调栈解答温度计问题进行改正
 * <p>
 * 收获：
 * 1.注意：思维拓宽，集合或者容器并不只是只能存储元素本身，还可以存储小标，在需要得到两个元素之间的距离的时候，存储下标将很有用
 * 2.注意：方法的功能语义和变量命名规范
 *
 * @author hxcoder
 */
public class SolutionStackImproveTwo {

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        SolutionStackImproveTwo s = new SolutionStackImproveTwo();
        int[] result = s.dailyTemperatures(temperatures);
        for (int el : result) {
            System.out.println(el);
        }
    }

    public int[] dailyTemperatures(int[] T) {
        // 使用双向队列，可以满足栈的使用，同时也可以满足其他功能
        // 存储数组元素下标
        Deque<Integer> stack = new LinkedList();
        int[] ans = new int[T.length];
        int len = T.length;
        for (int i = 0; i < len; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int index = stack.pop();
                // 重难点：单调栈存储下标，然后使用下标对应的元素进行比较，最后两个之间的距离就是两个下标只差，再也不用进行计数
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}