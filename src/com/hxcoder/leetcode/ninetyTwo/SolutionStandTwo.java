package com.hxcoder.leetcode.ninetyTwo;

/**
 * 解题思路：一次遍历「穿针引线」反转链表（头插法）
 * <p>
 * 收获：
 * 1.链表的头插法：
 * 流程：通常会有三个指针——prev curr next。主要功能就是next的节点插入到prev后面
 * 注意：prev curr并不会发生改变，只是prev和curr之间的距离会慢慢变大，因为prev后面不断插入新节点
 * 2.为了避免处理边界特殊情况，一般会设置dummy，使得操作统一
 */
public class SolutionStandTwo {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
