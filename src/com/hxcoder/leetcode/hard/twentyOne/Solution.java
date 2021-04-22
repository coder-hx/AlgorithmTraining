package com.hxcoder.leetcode.hard.twentyOne;

/**
 * 21. 合并两个有序链表
 * 要求：
 * 将两个升序链表合并为一个新的升序链表并返回
 * 新链表是通过拼接给定的两个链表的所有节点组成的
 * <p>
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 解题思路：
 * 1.使用双指针技巧，比较两条链表的节点大小，然后选取更小的节点的值，作为新节点的值
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 合并之后的新链表
        ListNode newList = new ListNode();
        ListNode dummyList = newList;

        // 双指针
        ListNode l1Head = l1;
        ListNode l2Head = l2;

        while (l1 != null && l2 != null) {
            // 比较大小
            if (l1.val < l2.val) {
                // 构造新节点
                // 拼接
                dummyList.next = new ListNode(l1.val);
                // 移动dummy指针
                dummyList = dummyList.next;
                // 移动l1指针
                l1 = l1.next;
            } else {
                // 构造新节点
                // 拼接
                dummyList.next = new ListNode(l2.val);
                // 移动dummy指针
                dummyList = dummyList.next;
                // 移动l1指针
                l2 = l2.next;
            }
        }

        // 处理l1不为空的情况
        if (l1 != null) {
            dummyList.next = l1;
        }

        // 处理l2不为空的情况
        if (l2 != null) {
            dummyList.next = l2;
        }

        return newList.next;
    }
}
