package com.hxcoder.complete.medium.twoHundredSix;

public class Solution1 {

    public static void main(String[] args) {

    }

    /**
     * 递归逆转整个链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // 递归
        ListNode node = reverseList(head.next);

        // 对基本的每一部分进行操作
        head.next.next = head;
        head.next = null;
        return node;
    }
}