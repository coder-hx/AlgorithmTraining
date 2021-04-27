package com.hxcoder.complete.medium.twentyFive;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 遍历输出链表
     *
     * @param list
     */
    public void outputEL(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
