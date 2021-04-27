package com.hxcoder.complete.medium.oneHundredEleven;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111.二叉树的最小深度
 * 解决思路：
 * 1.使用BFS，搜索层数最小的叶子节点
 * 2.递归求二叉树的深度，然后进行比较，返回其最小值
 * <p>
 * 收获：
 * 1.编程时，如果涉及到需要过去一段时间的状态，就一定要找到在程序中那些变量是过去的，从而和现在进行联系
 * 2.由于队列的先进先出的特性，所以一般用于实现BFS
 *
 * @author hxcoder
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 使用BFS，返回二叉树最小的深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 注意：理解：size是队列添加“周围元素”之前的大小，所以利用size就可以很巧妙的避免“新元素”和“旧元素”混合的现象
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}