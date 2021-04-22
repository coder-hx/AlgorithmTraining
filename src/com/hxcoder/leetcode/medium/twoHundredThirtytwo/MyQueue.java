package com.hxcoder.leetcode.medium.twoHundredThirtytwo;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 要求：
 * 使用两个栈实现先入先出队列
 * 只能使用标准的栈操作 —— 也就是只有 push top peek pop top size isEmpty
 * 可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可
 * <p>
 * 提示：
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 * <p>
 * 进阶：
 * 实现每个操作均摊时间复杂度为 O(1) 的队列——>执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间
 */
public class MyQueue {

    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /**
     * 将元素 x 推到队列的末尾
     */
    public void push(int x) {
        inputStack.add(x);
    }

    /**
     * 从队列的开头移除并返回元素
     */
    public int pop() {
        if (!outputStack.isEmpty()) {
            return outputStack.pop();
        }
        while (!inputStack.isEmpty()) {
            outputStack.add(inputStack.pop());
        }
        return outputStack.pop();
    }

    /**
     * 返回队列开头的元素
     */
    public int peek() {
        int temp = this.pop();
        outputStack.add(temp);
        return temp;
    }

    /**
     * 如果队列为空，返回 true ；否则，返回 false
     */
    public boolean empty() {
        return (inputStack.isEmpty() && outputStack.isEmpty());
    }
}