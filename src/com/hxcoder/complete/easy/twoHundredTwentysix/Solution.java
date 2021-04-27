package com.hxcoder.complete.easy.twoHundredTwentysix;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树
 * <p>
 * 解题思路：
 * 1.使用BFS，存储每一层的节点，然后针对这一层的节点的子节点进行反转。当遍历完整个树，最后的二叉树就是反转之后的二叉树
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize; i++) {
                TreeNode node = deque.poll();
                swapNode(node);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 交换一个节点下的左右节点
     */
    private void swapNode(TreeNode node) {
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
    }
}
