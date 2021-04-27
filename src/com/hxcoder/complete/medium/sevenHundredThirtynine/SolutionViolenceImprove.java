package com.hxcoder.complete.medium.sevenHundredThirtynine;

import java.util.Arrays;

/**
 * @author hxcoder
 */
public class SolutionViolenceImprove {

    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        int[] next = new int[101];

        Arrays.fill(next, Integer.MAX_VALUE);

        for (int i = length - 1; i >= 0; i--) {
            int minIndex = Integer.MAX_VALUE;

            // 核心：遍历next数组，寻找最T[i]大的温度的最小下标
            for (int j = T[i] + 1; j < next.length; j++) {
                if (next[j] < minIndex) {
                    minIndex = next[j];
                }
            }
            if (minIndex < Integer.MAX_VALUE) {
                ans[i] = minIndex - i;
            }
            // 注意：变量的准确定义：next：表示以温度为下标，值为T中的温度的下标
            next[T[i]] = i;
        }
        return ans;
    }
}
