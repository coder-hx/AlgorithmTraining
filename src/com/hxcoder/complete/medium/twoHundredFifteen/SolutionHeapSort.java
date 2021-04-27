package com.hxcoder.complete.medium.twoHundredFifteen;

/**
 * 使用堆排序解决TopK问题
 *
 * @author hxcoder
 */
public class SolutionHeapSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 6, 4};
        System.out.println(new SolutionHeapSort().findKthLargest(array, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        // 收获：程序的设计：
        // 注意：这里的heapSize可以用于控制堆化最后一个元素的位置，从而起到用最后一个元素替换第一个元素的效果
        // 循环条件：i >= nums.length - k + 1
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        // 注意：这里设计的很巧妙：由于先进行了一次build，而swap始终比build少一次，所以最后的结果就是nums[0]上的元素
        return nums[0];
    }

    /**
     * 构建最大堆
     *
     * @param arr
     */
    private void buildMaxHeap(int[] arr, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(arr, i, heapSize);
        }
    }

    /**
     * 将数组调整为最大堆（相当于在二叉树最后插入一个元素之后，进行调整，使最大堆的性质成立）
     *
     * @param arr
     * @param arrLen
     */
    private void maxHeapify(int[] arr, int i, int arrLen) {
        int lIdx = i * 2 + 1;
        int rIdx = i * 2 + 2;
        int largest = i;

        if (lIdx < arrLen && arr[lIdx] > arr[largest]) {
            largest = lIdx;
        }
        if (rIdx < arrLen && arr[rIdx] > arr[largest]) {
            largest = rIdx;
        }
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, arrLen);
        }
    }


    private void swap(int[] arr, int fIdx, int tIdx) {
        int temp = arr[fIdx];
        arr[fIdx] = arr[tIdx];
        arr[tIdx] = temp;
    }
}
