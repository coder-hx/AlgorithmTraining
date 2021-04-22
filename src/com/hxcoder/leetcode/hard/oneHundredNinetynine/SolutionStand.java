package com.hxcoder.leetcode.hard.oneHundredNinetynine;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路：使用DFS+二叉树的右视图节点数等于二叉树的层数，使用DFS首先遍历二叉树的右子树，然后根据depth和res（二叉树右视图节点数是否相等，来判断是否每一层的最右的节点）
 *
 * @author hxcoder
 */
public class SolutionStand {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        // 从根节点开始访问，根节点深度是0
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树
        // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
