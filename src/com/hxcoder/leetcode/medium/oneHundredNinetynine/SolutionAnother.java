package com.hxcoder.leetcode.medium.oneHundredNinetynine;

import java.util.LinkedList;
import java.util.List;

/**
 * 另一种解题思路：使用DFS+二叉树右视图节点数等于二叉树层数的关系进行解题
 * <p>
 * 收获：
 * 1.DFS的特点就是先遍历二叉树的一边
 * 2.使用DFS解题的关键是：找到只遍历一边和二叉树其他特点（层数）之间的关系
 *
 * @author hxcoder
 */
public class SolutionAnother {

    List<Integer> result = new LinkedList<>();

    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }

    /**
     * 使用DFS存储二叉树的右视图
     */
    private void dfs(TreeNode node, int depth) {
        // base case
        if (node == null) {
            return;
        }

        // 由于递归的时候，先向右子树遍历，所以当result.size==depth，说明node是depth这一层的最右边的节点，并且还没有添加进result
        if (result.size() == depth) {
            result.add(node.val);
        }
        depth++;
        // 先进行遍历右子树
        dfs(node.right, depth);
        dfs(node.left, depth);
    }
}