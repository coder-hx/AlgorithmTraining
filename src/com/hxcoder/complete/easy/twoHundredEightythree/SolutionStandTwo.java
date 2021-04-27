package com.hxcoder.complete.easy.twoHundredEightythree;

/**
 * @author hxcoder
 */
public class SolutionStandTwo {

    public static void main(String[] args) {
        int[] test = {111, 31, 21, 31231, 0, 231, 0, 312};
        SolutionStandTwo s = new SolutionStandTwo();
        s.moveZeroes(test);
        for (int x : test) {
            System.out.println(x);
        }
    }

    // 收获：
    // 1.直接采用下标，如果不为0，才进行依次赋值，为0就进行跳过，由于Index始终指向的是上一个已经处理好的下一个位置，所以可以直接进行覆盖
    // 2.处理完之后，index就是最后一个非0元素的下标
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
