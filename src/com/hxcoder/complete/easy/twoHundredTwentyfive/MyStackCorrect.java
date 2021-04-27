package com.hxcoder.complete.easy.twoHundredTwentyfive;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 算法改错：改正对问题错误建模
 * <p>
 * 解题思路：
 * 1.使用第一个队列进行存储push的数据，重点：pop数据时，为了统一操作，先将第一个队列中的所有数据全部转移到第二队列中，
 * 然后再将第二个队列中的(除了最后一个元素)的所有元素，全部转移到第一个队列中，Pop第二个队列中最后一个元素，最后注意：需要将第一个队列和第二个队列功能调换 ——>
 * 使用第二个队列进行push，第一个队列进行pop
 *
 * @author hxcoder
 */
public class MyStackCorrect {

    Deque<Integer> first;
    Deque<Integer> second;

    /**
     * Initialize your data structure here.
     */
    public MyStackCorrect() {
        first = new ArrayDeque<>();
        second = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        // ["MyStack","push","push","push","top"]
        // [[],[1],[2],[3],[]]
        // [null,null,null,null,3]
        MyStackCorrect s = new MyStackCorrect();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.top());
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        first.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        // 先将first队列中的所有元素转移到second
        while (!first.isEmpty()) {
            second.offer(first.poll());
        }
        // 将second中除最后一个元素转移到first
        // 注意：当集合或者数组容量作为循环停止条件时，一定要注意循环体吗内是否有改变容量大小的代码
        // 通用方法：将集合容量作为变量，存储在循环之前
        int size = second.size();
        for (int i = 0; i < size - 1; i++) {
            first.offer(second.poll());
        }
        int ans = second.poll();
        // first和second进行交换
        Deque<Integer> temp = first;
        first = second;
        second = temp;
        return ans;
    }

    /**
     * Get the top element.
     */
    public int top() {
        // 先使用pop
        int ans = pop();
        // 再使用push
        push(ans);
        return ans;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }
}
