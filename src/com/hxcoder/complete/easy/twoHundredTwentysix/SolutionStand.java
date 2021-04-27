package com.hxcoder.complete.easy.twoHundredTwentysix;

/**
 * 收获：二叉树问题一般使用递归就可以解决，注意：一般难点在于使用前/中/后序遍历——对问题合理建模
 *
 * @author hxcoder
 */
public class SolutionStand {

    public static void main(String[] args) {

    }

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
