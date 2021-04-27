package com.hxcoder.complete.easy.twoHundredEightythree;

/**
 * 使用下标，直接进行覆盖改进
 *
 * @author hxcoder
 */
public class SolutionImproveTwo {

    public static void main(String[] args) {

    }

    // 收获：
    // 1.编码时，不要被具体的流程所束缚，而是需要进行抽象，找到一种流程更见“统一 简洁”的流程进行代表
    // 2.有时，为了逻辑，编码统一，可以出现操作冗余
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int x : nums) {
            if (x != 0) {
                nums[index++] = x;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
