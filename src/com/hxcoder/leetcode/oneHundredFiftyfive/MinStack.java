package com.hxcoder.leetcode.oneHundredFiftyfive;

import java.util.Stack;

/**
 * 155. 最小栈
 * 要求：设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
 * 提示：pop、top 和 getMin 操作总是在 非空栈上调用
 * <p>
 * 解决方法：
 * 1.采用数组实现，push，pop，存储最小元素，getMin时直接返回，保证时间复杂度为常数级
 * 2.采用最小堆实现，push,pop操作时间复杂度将会比较高，但是getMin将保持常数级
 * 3.直接使用Java中提供的数据结构——构建一个一摸一样的数组，然后使用Arrays.sort()进行排序，然后返回最小，时间复杂度也是常数
 * <p>
 * 4.采用辅助栈，也就是对第一个方法的改进，使用辅助栈存储，每一个元素入栈时，这个时候栈的最小值
 *
 * @author hxcoder
 */
public class MinStack {

    /**
     * 存储数据栈
     */
    Stack<Integer> stack;

    /**
     * 存储当前入栈元素的最小元素
     */
    Stack<Integer> minStack;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.pop();
        minStack.getMin();
    }


    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        int minTop = minStack.peek();
        if (val < minTop) {
            minStack.push(val);
        } else {
            minStack.push(minTop);
        }
        stack.push(val);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        minStack.peek();
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
