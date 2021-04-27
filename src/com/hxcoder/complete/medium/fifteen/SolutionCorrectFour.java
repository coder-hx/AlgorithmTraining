package com.hxcoder.complete.medium.fifteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionCorrectFour {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> lists = new LinkedList<>();

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                return lists;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curr = nums[i];
            // 双指针：因为当b向右移动时，c一定是向左移动，才能保证最后的结果为0
            // 像这种一边向左，一边向右的情况，一般都考虑使用双指针
            int L = i + 1, R = len - 1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    // 保证答案唯一
                    while (L < R && nums[L + 1] == nums[L]) {
                        ++L;
                    }
                    while (L < R && nums[R - 1] == nums[R]) {
                        --R;
                    }
                    // 注意：这个时候，L和R一定是同时改变的，因为为了保证答案唯一
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
