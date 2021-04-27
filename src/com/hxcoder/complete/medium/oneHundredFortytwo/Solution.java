package com.hxcoder.complete.medium.oneHundredFortytwo;

/**
 * 142.环形链表 II
 * 要求：
 * 1.给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回 null
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）
 * 如果 pos 是 -1，则在该链表中没有环
 * 2.不允许修改给定的链表
 * 3.使用 O(1) 空间解决
 * <p>
 * 提示：
 * 链表中节点的数目范围在范围 [0, 10的4次方] 内
 * -10的5次方 <= Node.val <= 10的5次方
 * <p>
 * 解题思路：
 * 1.使用双指针技巧————>快慢指针判断是否存在环，然后根据快指针和慢指针走过的路径长度的关系，得出入环处
 *
 * @author hxcoder
 */
public class Solution {
    public static void main(String[] args) {
        // [3,2,0,-4]
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        Solution s = new Solution();
        s.detectCycle(a);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 出现环
            if (fast == slow) {
                // 根据fast和slow的路径长度关系，得到入环点
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
