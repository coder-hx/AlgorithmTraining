package com.hxcoder.leetcode.hard.fifteen;

import java.util.*;

/**
 * 15. 三数之和
 * 要求：
 * 包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c，使得 a + b + c = 0 ？
 * 找出所有和为 0 且不重复的三元组
 * 不可以包含重复的三元组
 * <p>
 * 提示：
 * 0 <= nums.length <= 3000
 * -10的5次方 <= nums[i] <= 10的5次方
 * <p>
 * 解题思路：
 * 1.a+b+c=0———>a+b=-c，遍历计算-(a+b)的值，然后再及进行判断，数据中有没有这个值（判断可以使用hashMap，提升效率）
 * 对于答案中不能有重复的———>只需要保证a,b不重复就可以了———>将添加进HashMap,每次进行判断（注意：这个时候需要添加两次，a、b各一次）
 * <p>
 * 错误：理解题意错误，返回的就是元素本身，而不是下标
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution s = new Solution();
        System.out.println(s.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new LinkedList<>();
        // 将数组元素作为key，数组下标作为value
        // 设计好处：同时起到了去除重复答案的效果
        HashMap<Integer, Integer> dpMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dpMap.put(nums[i], i);
        }
        Object[] objects = dpMap.keySet().toArray();
        for (int i = 0; i < objects.length - 1; i++) {
            int a = (int) objects[i];
            int b = (int) objects[i + 1];
            int sum = -(a + b);
            Integer temp = dpMap.get(sum);
            if (temp != null) {
                LinkedList<Integer> subAns = new LinkedList<>();
                subAns.add(dpMap.get(a));
                subAns.add(dpMap.get(b));
                subAns.add(dpMap.get(sum));
                ans.add(subAns);
            }
        }
        return ans;
    }
}
