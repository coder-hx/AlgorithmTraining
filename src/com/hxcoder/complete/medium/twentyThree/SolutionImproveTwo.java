package com.hxcoder.complete.medium.twentyThree;

import java.util.PriorityQueue;

/**
 * 算法改进：使用优先队列
 * <p>
 * 收获：
 * 1.如果需要对某个对象，进行排序，可以使用Java内置数据结构——优先队列——小顶堆
 * 但是，这个时候一定要指明对象之间比较大小的方式————>使对象所属类实现Comparable接口，重写compareTo方法，
 * 在这个方法里面指定对象之间比较大小的方式，最后将对象加入优先队列就可以了
 *
 * @author hxcoder
 */
public class SolutionImproveTwo {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        // Java优先队列默认为小顶堆
        PriorityQueue<Status> heap = new PriorityQueue<>();

        // 将lists中的所有节点添加到小顶堆中
        for (ListNode list : lists) {
            while (list != null) {
                heap.add(new Status(list.val, list));
                list = list.next;
            }
        }

        // 开始构造新链表
        ListNode result = new ListNode();
        ListNode dummy = result;
        while (!heap.isEmpty()) {
            dummy.next = new ListNode(heap.poll().val);
            dummy = dummy.next;
        }
        return result.next;
    }

    class Status implements Comparable<Status> {

        int val;
        ListNode node;

        public Status(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        @Override
        public int compareTo(Status status2) {
            // 将元素进行升序输出
            return this.val - status2.val;
        }
    }
}
