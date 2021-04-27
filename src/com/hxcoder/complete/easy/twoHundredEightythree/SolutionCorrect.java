package com.hxcoder.complete.easy.twoHundredEightythree;

/**
 * 改错：对边界问题进行改错
 * <p>
 * 收获：
 * 1.编写程序时，一定要注意循环中，循环终止条件和自增/自减之间的先后关系，处理不好，有可能会导致数组下标越界
 * 2.一般的处理方法：先尝试index+1 == nums.length ，在进行自增
 *
 * @author hxcoder
 */
public class SolutionCorrect {

    public static void main(String[] args) {
        int[] test = {111, 0, 21, 31231, 12, 231, 0, 312};
        SolutionCorrect s = new SolutionCorrect();
        s.moveZeroes(test);
        for (int x : test) {
            System.out.println(x);
        }
    }

    public void moveZeroes(int[] nums) {
        int first = 0, second = 0;
        int numsSize = nums.length;

        while (second < numsSize - 1) {
            // 使第一个指针指向第一个0位置
            while (nums[first] != 0) {
                if (first + 1 == numsSize) {
                    break;
                }
                first++;
            }

            // 如果first指向数组最后一个位置，就直接进行返回
            if (first == numsSize - 1) {
                return;
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
