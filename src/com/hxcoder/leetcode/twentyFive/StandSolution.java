package com.hxcoder.leetcode.twentyFive;

/**
 * @author hxcoder
 */
public class StandSolution {

    public static void main(String[] args) {
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        StandSolution s = new StandSolution();
        // [2,1,4,3,5]
        one.outputEL(s.reverseKGroup(one, 2));
    }

    /**
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        ListNode cur = head;
        int count = 1;
        while (cur != null && count < k) {
            count++;
            cur = cur.next;
        }

        if (cur == null) {
            return head;
        }

        ListNode other = cur.next;
        ListNode prev = reverseKGroup(other, k);
        ListNode temp = head;
        ListNode next;
        while (temp != other) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return cur;
    }
}
