package com.hxcoder.leetcode.hard.twentyThree;

/**
 * 解题思路：使用分治的思想+两条链表合并的算法————>合并k个有序链表
 * <p>
 * 收获：
 * 1.学习到了分治思想的应用
 * 2.分治算法中的分，一般是通过递归+二分实现
 * 3.分治算法中的治，是通过对分之后的递归回溯过程中的每一个节点进行操作————>将两个部分进行操作合并
 *
 * @author hxcoder
 */
public class SolutionImprove {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 将链表数组进行拆分，然后两两进行合并后，返回新有序链表的头节点
     * 使用二分进行拆分
     */
    private ListNode merge(ListNode[] lists, int l, int r) {
        // base case
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        // 分
        int mid = l + (r - l) / 2;
        // 合
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /**
     * 合并两个有序链表
     */
    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
