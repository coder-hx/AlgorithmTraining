package com.hxcoder.leetcode.twoHundredThirtysix;


/**
 * 解题思路：DFS 后序递归
 * <p>
 * 复杂度分析
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 * <p>
 * 收获：
 * 1.编程时碰到分支或者循环时，一定要穷举所有情况，然后才能编写条件
 * 2.编程时一定要明确返回值的所有情况，一定要考虑完所有情况
 */
public class SolutionStand {

    private TreeNode ans;

    public SolutionStand() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        // 代码解析：lson 和 rson 分别代表 x 节点的左孩子和右孩子
        // lson&&rson 说明左子树和右子树均包含p节点或q节点，p节点和q节点都是不同且唯一的节点，说明root就是要找的最近公共祖先
        // (root.val == p.val || root.val == q.val) && (lson || rson)：表示p,q在树的同一边，此时root也是要找的最近公共祖先

        // 我他么吐了啊，当p/q在同一条路径上时的情况，判断错误———>此时lson/rson将会相同，也就是条件判断后面起效
        // 注意：理解啊：lsno/rson表示的是相同的父节点，得出的是否有P/q的情况，当回溯到上层的时候，lson/rson就是上层的，这个时候条件判断将不会被满足
        // 注意：分清啊，递归的各个层次，变量的变化。可以通过一个特征值来进行判断，比如这里的root
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        // lson || rson：表示判断子树是否已经找到p/q
        // root.val == p.val || root.val == q.val 表示判断rooot是否是q/p
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}