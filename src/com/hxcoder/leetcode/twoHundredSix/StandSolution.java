package com.hxcoder.leetcode.twoHundredSix;

public class StandSolution {
    public static void main(String[] args) {

    }

    /**
     * 收获：
     * 1.编写函数的时候，一定要明确操作的变量是那个
     * 2.当循环条件不符合的，但是又必须进入的循环时，可以考虑使用函数操作变量，然后将之前的变量赋值新创建的变量，这样可以使循环操作统一
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}