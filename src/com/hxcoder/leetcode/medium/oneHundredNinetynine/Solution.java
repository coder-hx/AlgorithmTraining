package com.hxcoder.leetcode.medium.oneHundredNinetynine;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 要求：
 * 给定一棵二叉树，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
 * <p>
 * 解题思路：
 * 1.使用BFS，存储每一层的最后一个元素，就是二叉树的右视图
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {


    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode tempNode = queue.poll();
                if (i + 1 == queueSize) {
                    result.add(tempNode.val);
                }
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return result;
    }
}
