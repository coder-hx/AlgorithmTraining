package com.hxcoder.complete.easy.twoHundredTwentyfive;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hxcoder
 */
public class MyStackStand {
    //输入队列
    private Queue<Integer> a;
    //输出队列
    private Queue<Integer> b;

    public MyStackStand() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    /**
     * 重点：收获：每次Push元素时，都借助第二个队列，将这个元素推到第一个元素的第一个位置上，
     * 然后第一个队列和第二个队列交换位置
     */
    public void push(int x) {
        a.offer(x);
        // 将b队列中元素全部转给a队列
        while (!b.isEmpty()) {
            a.offer(b.poll());
        }
        // 交换a和b,使得a队列没有在push()的时候始终为空队列
        Queue temp = a;
        a = b;
        b = temp;
    }

    public int pop() {
        return b.poll();
    }

    public int top() {
        return b.peek();
    }

    public boolean empty() {
        return b.isEmpty();
    }
}
