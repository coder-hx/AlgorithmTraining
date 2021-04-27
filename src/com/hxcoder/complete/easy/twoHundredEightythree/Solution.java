package com.hxcoder.complete.easy.twoHundredEightythree;

/**
 * 283. 移动零
 * 给定一个数组 nums，将所有 0 移动到数组的末尾
 * 保持非零元素的相对顺序
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组
 * 尽量减少操作次数
 * <p>
 * 解题思路：
 * 1.使用双指针技巧，第一个指针指向第一个未替换的0，
 * 第二个指针指向第一个指针后的第一个非0位置
 * <p>
 * 错误：数组下标越界————边界没有处理好
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
        int[] test = {0, 1, 0, 3, 12};
        Solution s = new Solution();
        s.moveZeroes(test);
        System.out.println(s);
    }

    public void moveZeroes(int[] nums) {
        int first = 0, second = 0;
        int numsSize = nums.length;

        while (second < numsSize - 1) {
            // 使第一个指针指向第一个0位置
            while (nums[first] != 0) {
                first++;
            }

            // 使第二个指针指向第二个非0位置
            second = first + 1;
            while (second < numsSize - 1 && nums[second] == 0) {
                second++;
            }

            // 交换第一个指针位置元素和第二个指针位置元素
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;

            // 交换之后，继续上面的流程
            // 注意：这个时候，first+1就是第一个0的位置，而second+1，就是第一个非0的位置
            ++first;
        }
    }
}
