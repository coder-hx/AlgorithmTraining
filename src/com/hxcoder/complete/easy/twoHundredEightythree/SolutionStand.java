package com.hxcoder.complete.easy.twoHundredEightythree;

/**
 * @author hxcoder
 */
public class SolutionStand {

    public static void main(String[] args) {
        int[] test = {111, 31, 21, 31231, 0, 231, 0, 312};
        SolutionStand s = new SolutionStand();
        s.moveZeroes(test);
        for (int x : test) {
            System.out.println(x);
        }
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        // 注意：进行理解：left和right：right指向非0位置，left指向0位置，两者再进行交换
        // 巧妙：right和left同时移动，即使不为0的时候，也进行交换，当刚好right位置上为0时，left不懂，right继续向前，最后交换
        // 做到了移动指针和判断相统一
        // 为了使逻辑清晰，一些时候可以做出一些冗余操作
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
