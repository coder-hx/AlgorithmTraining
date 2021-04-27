package com.hxcoder.complete.medium.sevenHundredThirtynine;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 收获：
 * 1.
 *
 * @author hxcoder
 */
public class SolutionStandStackImprove {

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        SolutionStandStackImprove s = new SolutionStandStackImprove();
        int[] result = s.dailyTemperatures(temperatures);
        for (int el :
                result) {
            System.out.println(el);
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
