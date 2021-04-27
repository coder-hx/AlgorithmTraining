package com.hxcoder.complete.easy.twoHundredTwentyfive;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 * 使用两个队列实现一个后入先出（LIFO）的栈，
 * 并支持普通队列的全部四种操作（push、top、pop 和 empty）
 * <p>
 * 注意：
 * 只能使用队列的基本操作 —— 也就是push、peek/pop from front、size 和is empty
 * <p>
 * 提示：
 * 1 <= x <= 9
 * 最多调用100 次 push、pop、top 和 empty
 * 每次调用 pop 和 top 都保证栈不为空
 * <p>
 * 进阶：
 * 实现每种操作的均摊时间复杂度为 O(1) 的栈 ———— 执行 n 个操作的总时间复杂度 O(n)
 * <p>
 * 错误：原因：读题清晰，注意是使用队列实现栈，而不是使用栈实现队列
 *
 * @author hxcoder
 */
public class MyStack {

    Deque<Integer> inputQueue;
    Deque<Integer> outputQueue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        inputQueue = new LinkedList<>();
        outputQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        inputQueue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        ito();
        return outputQueue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        ito();
        return outputQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return outputQueue.isEmpty() && inputQueue.isEmpty();
    }

    private void ito() {
        if (outputQueue.isEmpty()) {
            while (!inputQueue.isEmpty()) {
                outputQueue.offer(inputQueue.poll());
            }
        }
    }
}