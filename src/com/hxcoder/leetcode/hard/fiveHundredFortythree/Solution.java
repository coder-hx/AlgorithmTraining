package com.hxcoder.leetcode.hard.fiveHundredFortythree;

/**
 * 543. 二叉树的直径
 * 要求：
 * 给定一棵二叉树，你需要计算它的直径长度
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值
 * 两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * 解题思路：
 * 1.使用DFS，分别计算左右子树的最大深度，然后相加，最后就是最大直径
 * <p>
 * 出现问题：
 * 1.对于路径定义不清晰，我的递归函数求的是节点数，但是路径是节点数-1
 * 2.对于递归函数的理解错误，递归函数适用于子问题和原问题具有相同的结构，可以从子问题的解推出原问题的解
 * 注意：原问题和子问题的处理逻辑都是一样的
 * 3.对于子问题/子树和原问题/父亲节点的划分不够清楚，所以导致编码时，逻辑混乱
 * <p>
 * 收获:
 * 1.递归理解：相同的问题结构，相同的问题处理方法
 * 2.对于二叉树中有求最值的情况，一般是使用一个变量记录，然后与每次递归的子结构进行比较之后，进行更新
 * 3.递归函数的编码一定要注意：不要深入其递归的过程，一定要明确每一行代码的功能（可以根据最简单的情况进行处理）
 * 4.递归函数的编码，一定要注意方法的放回值（子问题提供的解答），如何组成原问题的解答之间的关系
 * 5.一定要明确原问题和子问题的边界划分
 * 6.对于二叉树求最值问题，递归函数的返回可能并不是最终需要的返回值，而可能是一个成员变量
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {


    }


    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        // 注意：ans是路径上的最大节点数，所有路径长度=节点数-1
        return ans - 1;
    }

    /**
     * 返回树的最大深度（路径最多上最多节点数-1）
     */
    private int deep(TreeNode tree) {
        // base case
        if (tree == null) {
            return 0;
        }

        // 进行递归，分解原问题
        // 注意：这个时候千万不要深入递归过程，明确函数定义之后，只需要关系子问题的解和原问题的解之间的关系
        int leftDeep = deep(tree.left);
        int rightDeep = deep(tree.right);

        // 对于每个子问题的解的其他逻辑处理
        ans = Math.max(leftDeep + rightDeep + 1, ans);

        // 子问题的返回
        return Math.max(leftDeep, rightDeep) + 1;
    }
}
