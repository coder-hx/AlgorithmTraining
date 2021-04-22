package com.hxcoder.leetcode.hard.twentyOne;

/**
 * 最初解法：
 * 双指针比较两个节点值的大小，然后构造新的节点
 * <p>
 * 存在问题：
 * 空间复杂度较大，时间复杂度较大
 * <p>
 * 思路改进：
 * 使用循环迭代，通过改变节点指针的方式+不构造新节点，构造出新链表
 *
 * @author hxcoder
 */
public class SolutionImprove {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头节点，统一操作
        ListNode dummyNod = new ListNode();

        while (l1 != null && l2 != null) {
            // 辅助节点
            ListNode tempNode;

            // 出现错误：当l2中的一个节点比l1中的几个节点都大时，有可能会出现环形链表的情况
            if (l1.val < l2.val) {
                tempNode = l1.next;
                l1.next = l2;
                l1 = tempNode;
            } else {
                tempNode = l2.next;
                l2.next = l1;
                l2 = tempNode;
            }
        }
        return null;
    }
}
