package com.hxcoder.leetcode.hard.twentyFour;

/**
 * 24. 两两交换链表中的节点
 * 要求：
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
 * 需要实际的进行节点交换
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 解题思路：
 * 1.根据分析：两两交换之后的链表=以奇数的子链表+以偶数的子链表，两个合并，最后就是需要求的链表
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode evenList = head;
        ListNode oddList = head.next;
        ListNode firstList = evenList;
        ListNode second = oddList;

        // 将链表拆分为奇数链表和偶数链表
        while (oddList != null) {
            evenList.next = oddList.next;
            evenList = evenList.next;
            oddList.next = evenList.next;
            oddList = oddList.next;
        }

        // 合并两个链表
        return mergeList(firstList, second);
    }


    /**
     * 合并两个链表
     */
    private ListNode mergeList(ListNode evenList, ListNode oddList) {
        // 结果链表
        ListNode result = oddList;

        while (oddList != null && evenList != null) {
            ListNode temp = evenList.next;
            evenList.next = oddList.next;
            oddList.next = evenList;
            oddList = evenList.next;
            evenList = temp;
        }
        return result;
    }
}
