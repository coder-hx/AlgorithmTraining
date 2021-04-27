package com.hxcoder.complete.easy.twoHundredTwentyfive;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 算法思想改进：
 * 1.使用辅助队列，将push队列的元素推到队列的“第一个位置”
 * 2.交换队列，使得push队列一直保持为空
 *
 * @author hxcoder
 */
public class MyStackImprove {

    Queue<Integer> first;
    Queue<Integer> second;
    Queue<Integer> temp;

    /**
     * Initialize your data structure here.
     */
    public MyStackImprove() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        first.offer(x);
        // 将x推到第一个位置，使之拥有栈的性质
        while (!second.isEmpty()) {
            first.offer(second.poll());
        }
        temp = first;
        first = second;
        second = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return second.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return second.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return second.isEmpty();
    }
}
