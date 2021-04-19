package com.hxcoder.leetcode.twoHundredThirtysix;

/**
 * DFS后序遍历
 * <p>
 * 收获：
 * 1.递归函数的写法中的条件判断，因为每一层递归之后都会发生变化，所以一定要考虑返回值的所有情况和base case的所有情况，然后根据穷举结果进行if判断
 */
public class SolutionStandTwo {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 太你妈精髓了，直接将left和right的各个情况进行判断，同属于一条路径和不同属，各自进行判断
        if (left == null && right == null) {
            return null; // 1.
        }
        if (left == null) {
            return right; // 3.
        }
        if (right == null) {
            return left; // 4.
        }
        return root; // 2. if(left != null and right != null)
    }
}
