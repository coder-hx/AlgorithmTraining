package com.hxcoder.complete.hard.oneHundredTwentyfour;

/**
 * 124. 二叉树中的最大路径和
 * 要求：
 * 给出二叉树的根节点 root ，返回其最大路径和
 * 同一个节点在一条路径序列中 至多出现一次
 * 路径 至少包含一个 节点，且不一定经过根节点
 * 提示：
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * <p>
 * 解题思路:使用DFS+递归，不断更新最大路径和 + 以当前节点为起点的各个路径的最大路径
 * 1. 当前节点最大路径和计算：以当前节点为起点的所有路径和
 * 2. 当前节点对上一层的贡献：只能选择当前节点的最大的一条路径作为贡献，因为路径节点不可重复
 *
 * @author hxcoder
 */
public class Solution {

    static int ans = Integer.MIN_VALUE;
    int subMax = Integer.MIN_VALUE;
    int subLeftMax = Integer.MIN_VALUE;
    int subRightMax = Integer.MIN_VALUE;
    int temp;

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode one = new TreeNode(-2);
        TreeNode two = new TreeNode(-3);
        TreeNode three = new TreeNode(1);
        TreeNode four = new TreeNode(3);
        TreeNode five = new TreeNode(-2);
        TreeNode six = new TreeNode(-1);

        tree.left = one;
        tree.right = two;

        one.left = three;
        two.left = four;

        two.left = five;
        three.left = six;

        Solution solution = new Solution();
        solution.maxPathSum(tree);
        // 10
        System.out.println(ans);
    }

    public int maxPathSum(TreeNode root) {

        return 0;
    }
}
