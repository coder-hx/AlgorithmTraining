package com.hxcoder.leetcode.medium.twoHundredFifteen;

import java.util.Random;

/**
 * 通过快速排序的思想，然后对”中间点“的选择上面，对快速选择进行优化，也就是当中间点k-1右边的元素都是有序，然后TopK就是k
 * <p>
 * 由于对中间点选择的不同，会导致快速排序的时间复杂度，会变成最糟的n的平方，所以我们只能控制一个区间，然后在这个区间引入随机化来加速这个过程，它的时间代价的期望是 O(n)
 */
public class SolutionQuickSelect {

    Random random = new Random();

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 6, 4};
        System.out.println(new SolutionQuickSelect().findKthLargest(array, 4));
    }

    public int findKthLargest(int[] nums, int k) {

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 在nums指定的下标范围，使用快速排序思想查找 index 上的元素
     *
     * @param a
     * @param l
     * @param r
     * @param index
     * @return
     */
    private int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    private int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    private int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
