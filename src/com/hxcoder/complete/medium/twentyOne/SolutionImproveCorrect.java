package com.hxcoder.complete.medium.twentyOne;

/**
 * 对SolutionImprove进行改错
 * <p>
 * 错误原因：没有针对问题进行正确建模
 * <p>
 * 改进之后的算法：l1和l2的节点进行比较大小，然后将较小的节点连接到dummy上，连接之后将最小节点排除比较——将指针向后移动
 *
 * @author hxcoder
 */
public class SolutionImproveCorrect {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        a.next = b;
        b.next = c;
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        d.next = e;
        e.next = f;

        SolutionImproveCorrect s = new SolutionImproveCorrect();
        s.mergeTwoLists(a, d);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode dummyNode = result;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummyNode.next = l1;
                l1 = l1.next;
                dummyNode = dummyNode.next;
            } else {
                dummyNode.next = l2;
                l2 = l2.next;
                dummyNode = dummyNode.next;
            }
        }
        if (l1 != null) {
            dummyNode.next = l1;
        }
        if (l2 != null) {
            dummyNode.next = l2;
        }
        return result.next;
    }
}
