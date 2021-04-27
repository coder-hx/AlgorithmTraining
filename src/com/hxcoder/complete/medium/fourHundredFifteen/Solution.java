package com.hxcoder.complete.medium.fourHundredFifteen;

/**
 * 415. 字符串相加
 * 要求：
 * 1.给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和
 * 2.不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * <p>
 * 提示：
 * 1.num1 和num2 都只包含数字 0-9
 * 2.num1 和num2 都不包含任何前导零
 * <p>
 * 解题思路：
 * 1.直接使用双指针，遍历一遍，使用多余的存储空间存储进位
 * <p>
 * 收获：1.使用迭代手法时，一定要注意细节  2.将数字字符转换为数字类型，可以利用ASC码进行转化——>字符-48=数字类型
 *
 * @author hxcoder
 */
public class Solution {

    int sum, carry = 0;
    boolean haveCarry = true;
    StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        String s1 = "9";
        String s2 = "9";
        Solution solution = new Solution();
        System.out.println(solution.addStrings(s1, s2));
    }

    /**
     * 出现问题
     * 1.代码冗余，进位出现错误，另外从个位开始计算，导致最后返回的字符串出现逆序
     * 解决方法：1.针对方法进行重构，2.直接使用StringBuilder的逆序方法直接进行逆序
     */
    public String addStrings(String num1, String num2) {
        int num1Size = num1.length() - 1;
        int num2Size = num2.length() - 1;
        while (num1Size >= 0 && num2Size >= 0) {
            sum = charToDigital(num1.charAt(num1Size--)) + charToDigital(num2.charAt(num2Size--)) + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum -= 10;
            } else {
                carry = 0;
            }
            result.append(sum);
        }
        if (num1Size >= 0) {
            remain(num1, num1Size, result);
        }
        if (num2Size >= 0) {
            remain(num2, num2Size, result);
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }


    /**
     * 操作剩下的字符
     */
    private void remain(String num, int size, StringBuilder result) {
        int digital;
        while (size >= 0) {
            digital = charToDigital(num.charAt(size--));
            sum = digital + carry;
            if (haveCarry) {
                if (sum >= 10) {
                    carry = sum / 10;
                    sum -= 10;
                } else {
                    haveCarry = false;
                    carry = 0;
                }
            }
            result.append(sum);
        }
    }

    /**
     * 将字符转换为ASC码对应的数字
     */
    private int charToDigital(char c) {
        return c - 48;
    }
}
