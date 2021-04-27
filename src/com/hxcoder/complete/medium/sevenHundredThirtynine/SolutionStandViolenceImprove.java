package com.hxcoder.complete.medium.sevenHundredThirtynine;

import java.util.Arrays;

/**
 * 对暴力解法进行优化，本质思想还是暴力遍历
 * <p>
 * 收获：
 * 1.对于两次循环如何减少重复求解，一般可以反向进行思考
 * 2.对于题目中，给了明显的条件范围时，可以考虑是否可以从将条件值作为数组的下标，来方便解题
 *
 * @author hxcoder
 */
public class SolutionStandViolenceImprove {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        // 由于温度范围在30—100，所以设置next数组存储温度数组的温度对应的下标
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        // 反向遍历温度数组
        for (int i = length - 1; i >= 0; --i) {
            // warmerIndex：表示第一个最小温度的下标
            int warmerIndex = Integer.MAX_VALUE;
            // 由于温度是有范围的，加上遍历方向是有方向的，所以可以从右向左进行遍历
            // 注意:t=T[i]+1：表示只能从比t[i]大的温度范围中进行查找
            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmerIndex) {
                    // 将第一个比T[i]温度高的下标赋值给warmerIndex
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                // warmerIndex-i：下标相减就是两点之间的距离
                ans[i] = warmerIndex - i;
            }
            // 将T[i]和i加入next数组
            // 便于后续温度寻找第一个大的元素进行使用
            next[T[i]] = i;
        }
        return ans;
    }

}