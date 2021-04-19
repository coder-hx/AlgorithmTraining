package com.hxcoder.leetcode.oneHundredFortythree;

/**
 * 143. 重排链表
 * 要求：
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 需要实际的进行节点交换
 * <p>
 * 解决思路：
 * 1.根据分析有：重排之后的链表——>原来链表的前一部分和后一部分的逆序两个结合而成——>快慢指针指向后一段链表的开头——>逆序有递归和迭代两种方法
 * 2.由于链表不支持随机访问，所以将链表存储在数组中，然后利用下标关系，重建链表
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode midNode = findMid(head);
        ListNode reverseNode = reverseList(midNode);
        megerList(head, reverseNode);
    }


    /**
     * @param list
     * @return
     */
    private ListNode findMid(ListNode list) {
        ListNode fast = list;
        ListNode slow = list;
        ListNode tempNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        tempNode = slow;
        slow = slow.next;
        tempNode.next = null;
        return slow;
    }

    /**
     * 逆序链表
     *
     * @param list
     * @return
     */
    private ListNode reverseList(ListNode list) {
        if (list.next == null) {
            return list;
        }
        ListNode node = reverseList(list.next);
        list.next.next = list;
        list.next = null;
        return node;
    }

    /**
     * 合并两个链表
     *
     * @param list1
     * @param list2
     * @return
     */
    private ListNode megerList(ListNode list1, ListNode list2) {
        ListNode temp = list2.next;
        while (list2 != null) {
            list2.next = list1.next;
            list1.next = list2;
            list1 = list2.next;
            list2 = temp;
            if (temp != null) {
                temp = temp.next;
            }
        }
        return list1;
    }
}
