package com.hxcoder.leetcode.medium.ninetyTwo;

/**
 * 思路改进：一次遍历：穿针引线+头插法
 *
 * @author hxcoder
 */
public class SolutionImprove {

    public static void main(String[] args) {


    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            // 头插法
            // 注意：使用头插法时，由于curr会相当于不断往前走，所以进行头插时，不能借用curr，只能借用prev,next
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyNode.next;
    }
}
