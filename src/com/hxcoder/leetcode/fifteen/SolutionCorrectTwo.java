package com.hxcoder.leetcode.fifteen;

import java.util.*;

/**
 * 错误：
 * 1.对多个List进行比较后，去重，难度过大
 * 2.多次循环遍历，导致超时
 *
 * @author hxcoder
 */
public class SolutionCorrectTwo {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        SolutionCorrectTwo s = new SolutionCorrectTwo();
        System.out.println(s.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int temp = -(a + b);

        }

        return ans;
    }
}
