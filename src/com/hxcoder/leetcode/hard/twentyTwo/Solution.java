package com.hxcoder.leetcode.hard.twentyTwo;

/**
 * 22.链表中倒数第k个节点
 * 要求：
 * 输入一个链表，输出该链表中倒数第k个节点
 * 从1开始计数，即链表的尾节点是倒数第1个节点
 * <p>
 * 解题思路：
 * 1.使用双指针技巧，先定位到倒数第k的节点，然后进行返回
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null && k == 1) {
            return head;
        }
        ListNode first = head;
        ListNode second = first;

        for (int i = 0; i < k - 1; i++) {
            second = second.next;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
