package com.hxcoder.complete.medium.fifteen;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 改进思路：
 * 由于需要保证答案的唯一 ———> 所以想到对nums进行处理，保证唯一。但是这样会导致缺少几种答案。
 * ———> 所以想到对结果直接进行去重，但是由于子结构是List，难以进行比较和去重。
 * <p>
 * 核心难点就是保证答案唯一 ———> 对nums进行排序，就可以保证答案唯一
 * <p>
 * 解题思路：排序+双指针
 * <p>
 * 错误原因：基本逻辑错误，去重主要是针对于结果集，而不是nums数组，自己的逻辑定义并不清楚，所以导致胡乱排除元素，导致最后错误
 * <p>
 * 收获：
 * 1.程序发生错误的时候，一定不要先急着调试，改错。变成的本质就是保证逻辑一定要正确，所以出现错误的时候，一定要反省自己的逻辑是否正确
 * 2.一定要明确，计算机解决问题的做法，其实就是暴力穷举，而工程师考虑的不过是怎么进行更快的穷举。所以在思考解法的时候，一定要从暴力解法的基础上解题，才能保证基础逻辑正确。
 * 3.一定要清楚特殊情况的执行情况
 * 4.解题时，对于问题的建模一定要清晰，题意一定要明白
 *
 * @author hxcoder
 */
public class SolutionCorrectThree {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};
        SolutionCorrectThree s = new SolutionCorrectThree();
        System.out.println(s.threeSum(nums));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new LinkedList<>();

        // 特殊情况
        if (len < 3) {
            return ans;
        }
        // 对数组进行排序，保证答案唯一
        Arrays.sort(nums);
        // 双指针寻找答案
        int leftIdx = 0;
        int rightIdx = len - 1;
        int tempIdx;
        int assistIdx;
        int left;
        int right;
        int temp;

        while (leftIdx < rightIdx) {
            left = nums[leftIdx];
            right = nums[rightIdx];
            assistIdx = leftIdx + 1;
            temp = -(left + right);
            tempIdx = -1;
            for (int i = assistIdx; i < rightIdx; i++) {
                if (temp == nums[i]) {
                    tempIdx = i;
                    break;
                }
            }
            if (leftIdx < tempIdx && tempIdx < rightIdx) {
                List<Integer> subAns = new LinkedList<>();
                subAns.add(left);
                subAns.add(right);
                subAns.add(temp);
                ans.add(subAns);
            }

            if (temp > 0) {
                if (left == nums[leftIdx + 1]) {
                    while ((leftIdx + 1) < len && left == nums[leftIdx + 1]) {
                        leftIdx += 2;
                    }
                    continue;
                }
                ++leftIdx;
            }

            if (temp <= 0) {
                if (right == nums[rightIdx - 1]) {
                    while ((rightIdx - 1) >= 0 && right == nums[rightIdx - 1]) {
                        rightIdx -= 2;
                    }
                    continue;
                }
                --rightIdx;
            }
        }
        return ans;
    }
}
