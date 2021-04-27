package com.hxcoder.complete.medium.oneHundredTwo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 要求：
 * 一个二叉树，返回其按 层序遍历 得到的节点值
 * <p>
 * 解题思路：
 * 使用BFS直接进行层序遍历
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subAns = new LinkedList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode tempNode = queue.poll();
                subAns.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            ans.add(subAns);
        }
        return ans;
    }
}
