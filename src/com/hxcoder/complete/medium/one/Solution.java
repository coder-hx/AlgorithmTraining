package com.hxcoder.complete.medium.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 要求：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标
 * <p>
 * 提示；
 * 每种输入只会对应一个答案
 * 数组中同一个元素在答案里不能重复出现
 * 2 <= nums.length <= 103
 * <p>
 * 解题思路：
 * 1.暴力枚举，遍历两次数组，当遇到和为target，就进行返回
 * 2.进阶解法：可以换一种思路：将求x+y=target转换为x=target-y,需要快速找到元素对应的下标，所以可以考虑使用hashmap进行存储。
 * 但是要求同一个元素不能在答案中出现，所以判断之后，要从hashMap进行去除
 * <p>
 * 收获：注意一个可以将两次遍历，时间复杂度为平方的算法，改进为时间复杂度为线性的思想————对于可能性，要进行加法，而不要进行减法——思想核心，由于是逐渐增加可能性，所以以前的可能就已经被确认了，所以不会像减法一样，多处一次重复的判断
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
