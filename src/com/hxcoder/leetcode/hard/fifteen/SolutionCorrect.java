package com.hxcoder.leetcode.hard.fifteen;

import java.util.*;

/**
 * 出现问题：
 * 1.理解错误：对nums去重，是会保证答案唯一，但是会少掉一些答案。比如：(-1,-1,2)
 * 改进方法：由处理nums来保证唯一，变为直接处理结果集来保证唯一 ———> 直接对subList进行去重
 */
public class SolutionCorrect {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        SolutionCorrect s = new SolutionCorrect();
        System.out.println(s.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        // 去除nums中相同的元素，保证答案唯一
        for (int num : nums) {
            set.add(num);
        }

        Integer[] array = set.toArray(new Integer[0]);
        // 注意：i+=2，步幅必须大于1，因为三个数相加的话，步幅为1有可能导致同样的答案重复
        for (int i = 0; i < array.length - 1; i += 2) {
            int a = array[i];
            int b = array[i + 1];
            int temp = -(a + b);
            if (set.contains(temp)) {
                List<Integer> subAns = new LinkedList<>();
                subAns.add(a);
                subAns.add(b);
                subAns.add(temp);
                ans.add(subAns);
            }
        }
        return ans;
    }
}
