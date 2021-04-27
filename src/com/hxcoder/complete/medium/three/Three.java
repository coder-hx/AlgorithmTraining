package com.hxcoder.complete.medium.three;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 解决思路：使用**滑动窗口思想**解题
 * 收获：
 * 1.解决算法题时，一定要明确程序各个变量的定义，然后一定要确定特殊情况的，
 * 一般对于数组或者链表的第一个元素，要想统一操作，需要采用虚拟头节点的思想。这种时候一定要明确函数的定义
 * 2.当只是暂时需要变量改变的时，可以使用表达式，来暂时表示，需要变量永久发生改变时，才使用自增操作
 *
 * @author hxcoder
 */
public class Three {
    public static void main(String[] args) {
        String s = "w";
        Three three = new Three();
        System.out.println(three.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int strLength = s.length();
        int res = 0;
        int ridx = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < strLength; i++) {
            while (ridx < strLength - 1) {
                char c = s.charAt(++ridx);
                if (set.contains(c)) {
                    ridx--;
                    break;
                }
                set.add(c);
            }
            res = Math.max(res, ridx - i + 1);
            set.remove(s.charAt(i));
        }
        return res;
    }
}
