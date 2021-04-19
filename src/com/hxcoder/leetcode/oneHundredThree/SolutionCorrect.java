package com.hxcoder.leetcode.oneHundredThree;

import java.util.*;

/**
 * 使用BFS锯齿状遍历输出二叉树
 *
 * @author hxcoder
 */
public class SolutionCorrect {

    public static void main(String[] args) {


    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 特殊情况
        if (root == null) {
            return new LinkedList<>();
        }

        // 队列，将元素周围的元素加入
        Queue<TreeNode> queue = new LinkedList<>();

        // 用于标识BFS到第几层了，用于判断什么时候进行从右向左进行输出
        int count = 0;

        // 将根节点入队列
        queue.add(root);

        // 结果
        List<List<Integer>> result = new LinkedList<>();

        // BFS遍历
        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList<>();
            // 用于处理同一层的元素
            // 注意：不能将queue.size()直接整合在for循环中，因为每次循环时，都会向queue中添加新的数据
            int queSize = queue.size();
            // 注意：核心：使用for循环+queue.size()成功，将每一层分割开
            for (int i = 0; i < queSize; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 奇数层，说明从右向左进行输出
            if (count % 2 != 0) {
                Collections.reverse(subList);
            }
            result.add(subList);
            count++;
        }
        return result;
    }
}
