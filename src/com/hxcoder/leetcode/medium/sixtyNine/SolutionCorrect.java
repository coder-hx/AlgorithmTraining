package com.hxcoder.leetcode.medium.sixtyNine;

/**
 * 改错：熟悉二分搜索连续区间边界代码写法
 * <p>
 * 收获：
 * 1.多行同类型的变量赋值————>int a=1; int b=2; ————> int a=1,b=2;
 * 2.二分搜索时，一定要记得mid位置上的值，已经被处理之后判断了，所以在下一个区间时，不需要包括mid ————> left+1 / right-1
 * 3.二分搜索边界时，一定要注意返回条件并不是等于某个具体的值，而是 <= / >=
 * 4.二分搜索边界时，一定要注意返回值的更新，一定是在边界更新之前 ————> 因为如果更新边界在之前，就有可能导致更新完成的新边界，将会不符合要求
 * 5.出现两个数相乘，一般使用long进行存储，因为需要考虑数据溢出
 *
 * @author hxcoder
 */
public class SolutionCorrect {

    public static void main(String[] args) {
        int a = 8;
        SolutionCorrect s = new SolutionCorrect();
        System.out.println(s.mySqrt(a));
    }

    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            // 注意：二分搜索边界时，如果需要 下界 ————> 最后的结果就在 <= 中更新 / 需要上界，结果就在 >= 中更新
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
