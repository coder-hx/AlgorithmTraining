package com.hxcoder.complete.medium.fifteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 考察算法：排序 + 双指针
 * 难点在于如何去除重复解
 * <p>
 * 算法流程：
 * 1.特殊情况：对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []
 * 2.对数组进行排序
 * 3.遍历排序后数组：
 * 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果
 * 对于重复元素：跳过，避免出现重复解
 * 令左指针 L=i+1，右指针 R=n−1，当 L<R 时，执行循环：
 * 当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。
 * 并同时将 L,R 移到下一位置，寻找新的解
 * 若和大于 0，说明 nums[R] 太大，R 左移
 * 若和小于 0，说明 nums[L] 太小，L 右移
 * <p>
 * 复杂度分析
 * 时间复杂度：平方
 * 空间复杂度：O(1)
 */
public class SolutionStandOne {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) {
                return lists;
            }

            // 巧妙：i>0：防止遍历元素是第一个的情况，防止数组越界
            // nums[i] == nums[i-1]：防止这次遍历的元素和上次一样，导致重复解
            // 注意：明确定义：表示是这次和上一次遍历的比较。而不是和下一个的比较
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int curr = nums[i];
            int L = i + 1, R = len - 1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    // 排除重复解
                    while (L < R && nums[L + 1] == nums[L]) {
                        ++L;
                    }
                    while (L < R && nums[R - 1] == nums[R]) {
                        --R;
                    }
                    ++L;
                    --R;
                } else if (tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }
}
