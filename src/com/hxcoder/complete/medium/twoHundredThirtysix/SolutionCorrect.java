package com.hxcoder.complete.medium.twoHundredThirtysix;

/**
 * 改进：一定要明确
 *
 * @author hxcoder
 */
public class SolutionCorrect {
    TreeNode commonAncestor;
    TreeNode leftNode;
    TreeNode rightNode;

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

        SolutionCorrect s = new SolutionCorrect();
        s.lowestCommonAncestor(root, node5, node4);
        System.out.println(s.commonAncestor.val);
    }

    /**
     * 递归求二叉树中的某一个节点是否存在，如果存在就进行返回，如果不存在就返回null
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // base case 递归结束条件
        if (root == null) {
            return null;
        }

        // DFS：通常是前序遍历
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        leftNode = lowestCommonAncestor(root.left, p, q);
        // 判断当q,p位于同一条路线上时
        if ((root.val == p.val && leftNode.val == q.val) || (root.val == q.val && leftNode.val == p.val)) {
            commonAncestor = root;
            rightNode = root;
            return root;
        }

        rightNode = lowestCommonAncestor(root.right, p, q);
        // 判断当q,p位于同一条路线上时
        if ((root.val == p.val && rightNode.val == q.val) || (root.val == q.val && rightNode.val == p.val)) {
            commonAncestor = root;
            leftNode = root;
            return root;
        }

        // 判断q,p位于不同的路线上时
        if (leftNode != null && rightNode != null && leftNode.val != rightNode.val) {
            commonAncestor = root;
            return root;
        }
        return null;
    }
}
