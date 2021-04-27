package com.hxcoder.complete.medium.oneHundredNinetyeight;

/**
 * 每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，
 * 所以可以使用状态压缩对dp进行缩小
 * <p>
 * 收获:
 * 1.动态规划中的状态压缩：技巧：分析具体有几个状态参与转移，然后分析各个状态之间的时空关系，最后使用滚动数组/滑动窗口技巧，压缩dp数组
 *
 * @author hxcoder
 */
public class SolutionStandImprove {

    public static void main(String[] args) {
        int[] test = {2, 7, 9, 3, 1};
        SolutionStandImprove solution = new SolutionStandImprove();
        System.out.println(solution.rob(test));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int temp;
        for (int i = 2; i < length; i++) {
            // 注意：重难点：使用滑动数组优化动态规划空间复杂度
            // 滑动数组的本质：相当于维护一个“窗口”，然后 第二指针先移动，第一个指针指向原来第二个指针指向的位置，循环实现窗口向前移动
            temp = first;
            first = second;
            second = Math.max(temp + nums[i], second);
        }
        return second;
    }
}
