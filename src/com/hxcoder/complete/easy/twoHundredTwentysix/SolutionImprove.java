package com.hxcoder.complete.easy.twoHundredTwentysix;

public class SolutionImprove {

    public static void main(String[] args) {

    }


    /**
     * 递归函数定义：反转root为根节点的二叉树
     * <p>
     * 反转二叉树具有两个步骤：1.反装他的左右子树  2.反转左右子树 ———— 具有递归性质
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
