package com.hxcoder.leetcode.medium.ninetyTwo;

/**
 * 92. 反转链表 II
 * 要求：
 * 提供单链表的头指针 head 和两个整数 left 和 right，其中 left <= right。反转从位置 left 到位置 right 的链表节点，返回反转后的链表
 * <p>
 * 提示：
 * 链表中节点数目：1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * 进阶：使用一趟扫描完成反转
 * <p>
 * 解题思路：
 * 使用双指针技巧，首先定位到left和right位置上的节点，然后递归范围中的节点，注意对范围中的链表的头尾相接的节点要进行特殊处理
 *
 * @author hxcoder
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // 双指针移动到left和right指定的位置
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < right - left; i++) {
            second = second.next;
        }

        // 记录first的前一个节点
        ListNode prev = new ListNode();
        for (int i = 0; i < left - 1; i++) {
            if (i + 1 == left - 1) {
                prev = first;
            }
            first = first.next;
            second = second.next;
        }

        // 处理范围链表边界指针
        ListNode tempNode = first;
        ListNode tempNode1 = second;
        ListNode tempNode2 = second.next;

        // 递归逆序范围链表
        reverseList(first, second);
        // 处理边界
        tempNode.next = tempNode2;
        if (left == 1) {
            return tempNode1;
        }
        prev.next = tempNode1;
        return head;
    }

    /**
     * 递归逆序整个链表，返回逆序之后链表的头节点
     */
    private ListNode reverseList(ListNode list, ListNode stop) {
        // base case
        if (list == stop) {
            return list;
        }

        // 递归
        ListNode node = reverseList(list.next, stop);
        list.next.next = list;
        list.next = null;
        return node;
    }

    private void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
