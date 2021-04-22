package com.hxcoder.leetcode.hard.oneHundredThree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 解题思路：
 * 1.首先，明确不能使用递归，因为递归会首先先分解问题规模，最后才会考虑对每一个部分进行操作之后，组装起来形成最会的结果。
 * 相当于二叉树的后序遍历。但是考虑到需要同时对同一层的数据进行处理，所以最好不要使用递归
 * <p>
 * 2.明显这是层序遍历，所以需要使用二叉树的广度优先遍历——实现方法有：递归和迭代
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 使用BFS的非递归方法存储树节点，然后根据下标进行判断输出顺序
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        int deSize, level = 0;

        queue.offer(root);
        // BFS遍历二叉树
        while (!queue.isEmpty()) {
            deSize = queue.size();
            ans.add(insertByOrder(queue, level % 2 == 0));
            for (int i = 0; i < deSize; i++) {

                if (queue.poll() != null && queue.poll().right != null) {
                    queue.offer(queue.poll().right);
                }
                if (queue.poll() != null && queue.poll().left != null) {
                    queue.offer(queue.poll().left);
                }
            }
            level++;
        }
        return ans;
    }


    /**
     * 将queue中的节点的数据按照指定的leftOrder顺序存储到List中
     *
     * @param queue
     * @return
     */
    private List<Integer> insertByOrder(Queue<TreeNode> queue, boolean leftOrder) {
        // 构建一个子链表，用于存储这一层的节点
        List<Integer> result = new LinkedList<>();
        // 将queue转换为deque，便于后面的从右向左存储
        Deque<TreeNode> deque = (Deque<TreeNode>) queue;
        // 表示需要从左往右进行存储
        if (leftOrder) {
            while (!deque.isEmpty()) {
                result.add(deque.pollFirst().val);
            }
        } else {
            while (!deque.isEmpty()) {
                result.add(deque.pollLast().val);
            }
        }
        return result;
    }

}
