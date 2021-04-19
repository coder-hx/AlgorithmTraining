package com.hxcoder.leetcode.twoHundredThirtysix;

/**
 * 236. 二叉树的最近公共祖先
 * 要求：
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）
 * <p>
 * 提示：
 * 树中节点数目在范围 [2, 105] 内
 * -10的9次方 <= Node.val <= 10的9次方
 * 所有 Node.val 互不相同
 * p != q
 * p 和 q 均存在于给定的二叉树中
 * 一个节点也可以是它自己的祖先
 * <p>
 * 解题思路：
 * 1.使用DFS（由于每一次递归返回时，都是处理的每一层的节点），所以找到p/q，就进行返回。当两条路径在开始相遇的时候，就是“最近的公共组先”
 * <p>
 * 错误原因：对递归建模错误，对递归函数定义不清
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {
        // [3,5,1,6,2,0,8,null,null,7,4]
        //5
        //4
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node2);
        TreeNode node0 = new TreeNode(0, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node1 = new TreeNode(1, node0, node8);
        TreeNode root = new TreeNode(3, node5, node1);

        Solution s = new Solution();
        s.lowestCommonAncestor(root, node5, node4);
        System.out.println(s.commonAncestor.val);
    }

    TreeNode commonAncestor;
    TreeNode left;
    TreeNode right;

    /**
     * 递归求两个节点的最近组先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) {
            return null;
        }


        // DFS
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        if (leftNode != null) {
            left = leftNode;
            if (right != null) {
                commonAncestor = left;
            }
        }
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (rightNode != null) {
            right = rightNode;
            if (left != null) {
                commonAncestor = right;
            }
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        return null;
    }
}
