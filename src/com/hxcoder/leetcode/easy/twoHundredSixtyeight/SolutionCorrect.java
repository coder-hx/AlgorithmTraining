package com.hxcoder.leetcode.easy.twoHundredSixtyeight;

import java.util.HashMap;

/**
 * 算法改错：由于过分追求线性时间复杂度，所以导致基本算法逻辑错误，改为使用hash表
 *
 * @author hxcoder
 */
public class SolutionCorrect {

    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, x);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }
}
