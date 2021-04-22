package com.hxcoder.leetcode.medium.twoHundredThirtytwo;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 收获：
 * 1.Java 集合架构：Collection Map
 * Collection：List Set Queue / Map HashMap SortMap
 * List ——> ArrayList / LinkedList / Vector
 * Vector ——> Stack
 * Set ——> HashSet / SortedSet!
 * HashSet ——> LinkedHashSet!
 * SortedSet ——> TreeSet!
 * Queue ——> Deque / PriorityQueue
 * Deque ——> LinkedList / ArrayDeque!
 * Map:HashMap  HashTable  SortedMap
 * HashMap ——> LinkedHashMap
 * HashTable ——> Properties
 * SortMap ——> TreeMap
 * <p>
 * 2.对于集合框架的理解：应该是从集合功能上理解
 * 3.对于Java集合的深度理解：一般手动使用栈时，建议使用Deque，因为Stack继承Vector，线程安全，但是同步会导致效率减低
 *
 * @author hxcoder
 */
public class MyQueueStand {

    Deque<Integer> inStack;
    Deque<Integer> outStack;
    public MyQueueStand() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    public static void main(String[] args) {

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
