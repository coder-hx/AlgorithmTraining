package com.hxcoder.leetcode.oneHundredFortysix;

import java.util.Collection;
import java.util.HashMap;



public class LRUCacheCorrect {

    public static void main(String[] args) {

        // [null,null,null,null,null,-1,3]
        LRUCacheCorrect LRUCacheCorrect = new LRUCacheCorrect(2);
        LRUCacheCorrect.put(2, 1);
        LRUCacheCorrect.put(1, 1);
        LRUCacheCorrect.put(2, 3);
        LRUCacheCorrect.put(4, 1);
        LRUCacheCorrect.get(1);
        LRUCacheCorrect.get(2);
    }

    HashMap<Integer, twoWayList> map;
    twoWayList dummyHead;
    twoWayList dummyTail;
    int listSize;
    int capacity;

    public LRUCacheCorrect(int capacity) {
        // 构造双向链表
        // 构造双向链表的虚拟头尾节点
        dummyHead = new twoWayList(-1);
        dummyTail = new twoWayList(-1);
        dummyHead.next = dummyTail;
        dummyTail.prec = dummyHead;
        // 构造HashMap
        map = new HashMap<>();
        listSize = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        twoWayList node = map.get(key);
        if (node == null) {
            return -1;
        }
        //将node移动到头节点
        updateMove(node);
        return node.val;
    }

    public void put(int key, int value) {
        twoWayList node = map.get(key);
        if (node != null) {
            node.val = value;
            updateMove(node);
            return;
        }
        if (listSize >= capacity) {
            removeLast();
        }
        // 添加进双向链表中
        twoWayList newNode = new twoWayList(value);
        newNode.next = dummyHead.next;
        dummyHead.next.prec = newNode;
        dummyHead.next = newNode;
        newNode.prec = dummyHead;
        listSize++;
        // 添加进HashMap中
        map.put(key, newNode);
    }


    /**
     * 将node移动到头节点
     *
     * @param node
     */
    private void updateMove(twoWayList node) {
        // 删除
        node.prec.next = node.next;
        node.next.prec = node.prec;

        // 重新连接
        node.next = dummyHead.next;
        dummyHead.next.prec = node;
        dummyHead.next = node;
        node.prec = dummyHead;
    }

    /**
     * 删除最后一个元素
     */
    private void removeLast() {
        Collection<twoWayList> values = map.values();
        values.remove(dummyTail.prec);
        dummyTail.prec.prec.next = dummyTail;
        dummyTail.prec = dummyTail.prec.prec;
        listSize--;
    }


    /**
     * 双向链表
     */
    class twoWayList {

        int val;
        twoWayList prec;
        twoWayList next;

        twoWayList() {
        }

        public twoWayList(twoWayList prec) {
            this.prec = prec;
        }

        public twoWayList(int val) {
            this.val = val;
        }

        public twoWayList(int val, twoWayList prec, twoWayList next) {
            this.val = val;
            this.prec = prec;
            this.next = next;
        }
    }
}
