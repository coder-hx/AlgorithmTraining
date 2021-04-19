package com.hxcoder.leetcode.twoHundredThirtysix;

/**
 * 模仿SolutionStand，吸收其思想:合理使用DFS框架求解最短公共组先
 *
 * @author hxcoder
 */
public class SolutionStandImitate {

    public static void main(String[] args) {

    }

    TreeNode ans;

    public SolutionStandImitate() {
        this.ans = null;
    }

    /**
     * 查看以root为根节点的二叉树中是否含有p/q
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) {
            return false;
        }

        // DFS后序递归
        boolean leftIsExist = dfs(root.left, p, q);
        boolean rightIsExist = dfs(root.right, p, q);

        // 对”当前节点“的处理逻辑
        // leftIsExist && rightIsExist：表示以root为根节点的二叉树的左右分别有q/p，具体是左子树还是右子树交给上层递归进行处理
        // q/p分局两侧的情况：root.val==p.val || root.val == q.val && leftIsExist || rightIsExist
        if ((leftIsExist && rightIsExist) || ((root.val == p.val || root.val == q.val) && (leftIsExist || rightIsExist))) {
            ans = root;
        }

        // 每次递归向上返回的值：一定要明确这一次递归向上面返回的是我这个root是否有p/q
        // q/p 分局root两侧和局同一侧同时判断
        return leftIsExist || rightIsExist || root.val == p.val || root.val == q.val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
}
