package com.hxcoder.leetcode.medium.twentyFive;

/**
 * 25.K 个一组翻转链表
 * 进阶要求：1.只使用常数额外空间 2.需要实际进行节点交换
 * 提示：列表中节点的数量在范围 sz 内，1 <= sz <= 5000，0 <= Node.val <= 1000，1 <= k <= sz
 * <p>
 * 解题思想：
 * 1.迭代，采用分而治之的思想，对每一部分进行逆转，然后对于每一部分最后进行合并
 * 2.递归，同样采用分而治之的思想，递归的对k个一组的数据进行逆转，然后回溯的时候进行合并
 * <p>
 * 解题收获：1.一定要明确递归函数的语义，不然很难从递归中绕出来  2.一定要明确变量的的定义，不然写到一半，发现出现功能出现歧义  3.解题之前，一定要明确逻辑步骤，不然都不直到自己在写什么
 *
 * @author hxcoder
 */
public class Solution01 {

    public static void main(String[] args) {
        // 1,2,3,4,5
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        Solution01 s = new Solution01();
        // [2,1,4,3,5]
        one.outputEL(s.reverseKGroup(one, 2));
    }

    /**
     * K 个一组翻转链表
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 每一段的头节点
        ListNode prec = head;
        // 下一段的头节点
        ListNode nextPrec = moveByK(head, k);
        // 每一段的尾节点
        ListNode succ = moveByK(head, k - 1);
        // 辅助节点
        ListNode assistNode;

        // 递归对整个链表进行划分，然后分别处理，最后进行合并
        // base case：说明没有后继节点，prec就是最后一组的头节点
        if (succ == null) {
            // 如果最后一组元素数量不够，则保持原顺序
            return prec;
        }
        // 断开这两段
        succ.next = null;

        // 对基本数据进行处理
        assistNode = resverseByStep(prec, k);

        // 递归，划分问题规模
        // 注意：变量定义：assistNode：就是每一组元素的头节点
        prec.next = reverseKGroup(nextPrec, k);

        return assistNode;
    }

    /**
     * 移动k次，返回对应的节点（同时处理链表最后一段个数不足k的情况）
     *
     * @param list 待处理链表
     * @param k    移动次数
     * @return 对应节点
     */
    private ListNode moveByK(ListNode list, int k) {
        if (list == null) {
            return null;
        }
        for (int i = 0; i < k; i++) {
            list = list.next;
            if (list == null) {
                return null;
            }
        }
        return list;
    }

    /**
     * 递归将链表前k个元素进行逆序（同时也兼顾了逆序链表所有节点）
     *
     * @param list 待处理数组
     * @param k    需要逆序的前k的元素
     * @return 逆序之后链表的头节点
     */
    private ListNode resverseByStep(ListNode list, int k) {
        // base case
        if (k <= 1 || list.next == null) {
            return list;
        }

        // 递归
        ListNode node = resverseByStep(list.next, --k);

        // 对基本元素进行处理
        list.next.next = list;
        list.next = null;

        return node;
    }
}
