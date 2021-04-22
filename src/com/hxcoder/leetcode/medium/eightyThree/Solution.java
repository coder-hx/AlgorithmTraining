package com.hxcoder.leetcode.medium.eightyThree;

/**
 * 83. 删除排序链表中的重复元素
 * 要求：存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次
 * <p>
 * 提示；
 * 1.链表中节点数目在范围 [0, 300] 内
 * 2.-100 <= Node.val <= 100
 * 3.链表已经按升序排列
 * <p>
 * 解题思路：
 * 1.使用双指针，第一个指针指向第一个已经确定不一样的元素，后面一个指针则用于跳过相同的元素
 */
public class Solution {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;

        while (node2 != null) {
            // 遇到相同元素的节点
            if (node1.val == node2.val) {
                node1.next = node2.next;
            } else {
                node1 = node1.next;
            }
            node2 = node2.next;
        }
        return head;
    }
}
