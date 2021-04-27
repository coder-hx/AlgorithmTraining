package com.hxcoder.complete.medium.twentyOne;

/**
 * 进阶解法：
 * 使用递归，解决合并两个有序链表
 * <p>
 * 算法理解：
 * 递归过程：l1:1 2 4  l2:1 3 4
 * 1. 1 -> merge(2 4,1 3 4)
 * 2. 1 -> merge(2 4,1 3 4) -> 1 -> merge(1,merge(2 4,3 4))
 * ...
 * <p>
 * 收获：
 * 1.判断一个问题是否具有递归解法：主要是看原问题的解是否可以由子问题的解组合得出
 * 本题中，得出最小节点之后，发现最小节点的下一个节点，需要从l1/l2的子链表中得出，所以符合递归问题
 * 2.递归一定要明确函数定义和子问题如何组合成原问题的解答 ——> 如何进行正确的递归 ——> 如何进行正确的缩小问题规模
 *
 * @author hxcoder
 */
public class SolutionImproveTwo {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // base case
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 递归
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
