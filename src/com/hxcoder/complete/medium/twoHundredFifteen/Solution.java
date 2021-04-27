package com.hxcoder.complete.medium.twoHundredFifteen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 215.数组中的第K个最大元素
 * 提示：可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度
 * <p>
 * 错误：原因：理解题意错误：第k个其中包括了相同的元素
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(array, 4));
    }

    /**
     * 在未排序的数组中找到第 k 个最大的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // 注意：将set转换为array时，必须指明构造方法，不然由于toArray接收的是一个可变泛型类型参数，由于基本数据类型无法进行泛型化，所以转换后会将整个set看作是数组的一个元素
        Integer[] array = set.stream().toArray(Integer[]::new);
        Arrays.sort(array);
        return array[array.length - k];
    }
}
