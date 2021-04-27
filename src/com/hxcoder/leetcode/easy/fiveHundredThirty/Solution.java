package com.hxcoder.leetcode.easy.fiveHundredThirty;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 530.二叉搜索树的最小绝对差
 * 要求：
 * 一棵所有节点为非负值的二叉搜索树，计算树中任意两节点的差的绝对值的最小值
 * <p>
 * 提示：
 * 树中至少有 2 个节点
 * <p>
 * 解题思路：
 * 1.使用DFS，找出以n为根节点的二叉树的，和n绝对值最小的元素。不断递归缩小范围
 *
 * @author hxcoder
 */
public class Solution {

    int ans = Integer.MAX_VALUE, subAns = 0;

    public static void main(String[] args) {
        // [236,104,701,null,227,null,911]
        // 9
        TreeNode d = new TreeNode(227);
        TreeNode e = new TreeNode(911);
        TreeNode b = new TreeNode(104, null, d);
        TreeNode c = new TreeNode(701, null, e);
        TreeNode a = new TreeNode(236, b, c);

        Solution s = new Solution();
        System.out.println(s.getMinimumDifference(a));
    }

    /**
     * 使用BFS遍历所有节点的subAns，最后结果就是最小的subAns
     */
    public int getMinimumDifference(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            TreeNode node;
            for (int i = 0; i < dequeSize; i++) {
                node = deque.poll();
                ans = Math.min(getMinVal(node, node.val), ans);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return ans;
    }

    /**
     * 使用DFS返回和rootVal绝对值最小的元素
     */
    private int getMinVal(TreeNode tree, int rootVal) {
        // base case
        if (tree == null) {
            return 0;
        }
        // DFS前序遍历
        if (tree.left != null && tree.right != null) {
            subAns = Math.min(Math.abs(rootVal - tree.left.val), Math.abs(rootVal - tree.right.val));
        }
        if (tree.left == null && tree.right != null) {
            subAns = Math.abs(rootVal - tree.right.val);
        }
        if (tree.right == null && tree.left != null) {
            subAns = Math.abs(rootVal - tree.left.val);
        }
        if (tree.left != null) {
            subAns = Math.min(getMinVal(tree.left, rootVal), subAns);
        }
        if (tree.right != null) {
            subAns = Math.min(getMinVal(tree.right, rootVal), subAns);
        }
        return subAns;
    }
}
