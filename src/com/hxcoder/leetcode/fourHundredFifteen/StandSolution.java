package com.hxcoder.leetcode.fourHundredFifteen;

/**
 * 收获：
 * 1.当两个字符串长度不一样的时候，可以对短进行返回0。这样简化了操作
 * 2.将字符数字抓换为数字类型的时，可以借助0的ACS码值
 * 3.注意：/和%的区别
 */
public class StandSolution {

    public static void main(String[] args) {

    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            // 设计的太巧妙了，将长度不一样的字符操作，直接统一，然后短的返回0（不影响计算，同时简化编码难度）
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
