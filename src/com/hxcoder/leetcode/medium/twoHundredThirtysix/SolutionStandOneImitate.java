package com.hxcoder.leetcode.medium.twoHundredThirtysix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 模仿SolutionStandOne，吸收思想：使用HashMap存储所有节点的父节点
 * <p>
 * 收获：
 * 1.编写递归函数时，一定不要陷入递归逻辑，而是明确函数定义，类似于普通函数一样进行编写
 * 2.一定要明确，变量会进行怎么样的处理，然后明确逻辑，设计好之后，才开始动手编写，而不是快速写好之后，修补
 *
 * @author hxcoder
 */
public class SolutionStandOneImitate {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node2);
        TreeNode node0 = new TreeNode(0, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node1 = new TreeNode(1, node0, node8);
        TreeNode root = new TreeNode(3, node5, node1);

        SolutionStandOneImitate s = new SolutionStandOneImitate();
        System.out.println(s.lowestCommonAncestor(root, node5, node4).val);
    }

    HashMap<Integer, TreeNode> map;
    Set<Integer> visitedNode;

    public SolutionStandOneImitate() {
        this.map = new HashMap<>();
        this.visitedNode = new HashSet<>();
    }

    /**
     * 使用BFS存储二叉树所有节点的父节点
     */
    private void dfs(TreeNode tree) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(tree);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node.left != null) {
//                map.put(node.left.val, node);
//                queue.add(node.left);
//            }
//            if (node.right != null) {
//                map.put(node.right.val, node);
//                queue.add(node.right);
//            }
//        }

        // 改进使用:DFS递归存储父节点
        if (tree.left != null) {
            map.put(tree.left.val, tree);
            dfs(tree.left);
        }
        if (tree.right != null) {
            map.put(tree.right.val, tree);
            dfs(tree.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 改进：建议将局部变量提升为成员变量，因为多次使用这个方法将会导致出现大量重复对象
        // 而提升为成员变量之后，只有一个实例才会持有一份，并且初始更加方便
        dfs(root);
//        TreeNode pFatherNode = map.get(p.val);
//        visitedNode.add(p.val);
//        while (pFatherNode != null) {
//            visitedNode.add(pFatherNode.val);
//            // 将pFather向上移动
//            pFatherNode = map.get(pFatherNode.val);
//        }
//
//        if (visitedNode.contains(q.val)) {
//            return q;
//        }
        // 代码改进
        while (p != null) {
            visitedNode.add(p.val);
            p = map.get(p.val);
        }

//        TreeNode qFatherNode = map.get(q.val);
//        while (qFatherNode != null) {
//            if (visitedNode.contains(qFatherNode.val)) {
//                return qFatherNode;
//            }
//            // 将qFather向上移动
//            qFatherNode = map.get(qFatherNode.val);
//        }
        // 代码改进
        while (q != null) {
            if (visitedNode.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }
}
