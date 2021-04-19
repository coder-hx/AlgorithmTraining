package com.hxcoder.leetcode.twoHundredSix;

/**
 * 206. 反转链表
 * <p>
 * 解决思路：1.递归 2.迭代
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

    }


    /**
     * 迭代逆转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prec = null;
        ListNode curr = head;
        ListNode succ = head.next;
        while (succ != null) {
            curr.next = prec;
            prec = curr;
            curr = succ;
            succ = succ.next;
        }
        curr.next = prec;
        return curr;
    }
}