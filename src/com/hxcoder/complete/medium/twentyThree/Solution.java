package com.hxcoder.complete.medium.twentyThree;

/**
 * 23. 合并K个升序链表
 * 要求：
 * 链表数组中，每个链表都已经按升序排列
 * 将所有链表合并到一个升序链表中，返回合并后的链表
 * <p>
 * 提示：
 * 0 <= lists.length <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按升序排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 解题思路：
 * 1.从所有链表中选取最小的一个节点，构造新节点，然后对剩余链表进行同样操作
 * 2.分析发现，具有明显递归性质
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
    }

    public ListNode mergeKLists(ListNode[] lists) {

        int listsLen = lists.length;
        ListNode dummyNode = new ListNode(-1);
        ListNode result = dummyNode;
        // 最小节点的下标
        int minIndex = -1;
        // 最小节点的值
        int minVal = Integer.MAX_VALUE;
        while (!isEmpty(lists)) {
            for (int i = 0; i < listsLen; i++) {
                if (lists[i] != null && lists[i].val < minVal) {
                    minVal = lists[i].val;
                    minIndex = i;
                }
            }
            // 得到所有链表中最小的节点
            dummyNode.next = new ListNode(minVal);
            dummyNode = dummyNode.next;
            // 对原来的链表排除最下节点
            lists[minIndex] = lists[minIndex].next;
            // 重新矫正minIndex,minVal
            minIndex = -1;
            minVal = Integer.MAX_VALUE;
        }
        return result.next;
    }

    /**
     * 判断list中是否还有非空元素
     */
    private boolean isEmpty(ListNode[] list) {
        for (ListNode listNode : list) {
            if (listNode != null) {
                return false;
            }
        }
        return true;
    }
}
