package com.hxcoder.leetcode.easy.twoHundredSixtyeight;

import java.util.HashMap;
import java.util.Map;

/**
 * 268.丢失的数字
 * 要求：
 * 给定一个包含 [0, n] 中 n 个数的数组 nums
 * 找出 [0, n] 这个范围内没有出现在数组中的那个数
 * <p>
 * 进阶：
 * 实现线性时间复杂度、仅使用额外常数空间的算法
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 10的4次方
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 * <p>
 * 解题思路：
 * 1.使用数组下标+HashMap，将数组元素的值作为下标，访问并标记为-1，
 * 将结果存储到HashMap中，最后只要找找出不为-1的值就是丢失的数字
 * <p>
 * 错误：错误原因：基本算法逻辑错误，混乱
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
        int[] test = {0, 1};
        Solution s = new Solution();
        System.out.println(s.missingNumber(test));
    }

    public int missingNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        // 标记-1
        for (int i = 0; i < nums.length; i++) {
            // 注意：需要对最后一个元素特殊处理
            // 当nums[i] == nums.length时，需要将nums[i]--
            if (nums[i] != -1) {
                if (nums[i] == nums.length) {
                    continue;
                }
                nums[nums[i]] = -1;
                map.put(nums[i], nums[nums[i]]);
                if (nums[i] != -1) {
                    map.put(i, nums[i]);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
