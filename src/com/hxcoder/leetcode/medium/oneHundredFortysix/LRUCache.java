package com.hxcoder.leetcode.medium.oneHundredFortysix;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 146. LRU 缓存机制
 * 要求：
 * 设计和实现一个LRU (最近最少使用) 缓存机制
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间
 * <p>
 * 进阶：
 * 在 O(1) 时间复杂度内完成这两种操作
 * <p>
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 10的4次方
 * 最多调用 3 * 10的次方 次 get 和 put
 * <p>
 * 解题思路：
 * 1.由于要求在常数时间复杂度完成get/put，所以可以推导出使用——数组/hashMap/hashTable
 * 2.由于需要当容量到达最大限度时，删除数据，所以可以推导出使用——普通链表/双向链表（不能使用循环链表，因为必须要标识最近使用和最远未使用）
 * 3.总结：使用Java提供的双向链表和hashMap完成LRUCache
 * 具体设计想法：
 * 1.采用HashMap+带虚拟头结点的双向链表
 * 2.HashMap中存储每一条双向链表的头节点，而具体的节点数据则存储在链表中（注意：实现的是LRU，所以每次操作节点，除删除之外，都要将节点提到第一个节点）
 * 3.具体的HashMap怎么进行构造————>创建几条双向链表————>先不进行创建，等到add时候，根据key的hash结果，如果该位置上没有创建好的链表，就进行创建。如果该位置上有创建好的链表，就直接进行添加
 * 4.具体的hash怎么进行————>由于capacity <= 3000————> 所以考虑到性能和功能————> hash:1~3000%5：构造5条链表
 * <p>
 * 出现问题：
 * 1.当add时，链表容量已经达到最大时，如果最近最少使用的元素在其他链表，该怎么进行删除———>理解错误：最近的意思是当前操作的链表？？？
 * 2.链表容量设置多少合适？————>怎么设置链表容量？？————>发生错误：Java LinkedList底层没有容量限制，所以不能设置容量————>使用ArrayList/或者手动判断是否超出规定大小
 * <p>
 * 错误：
 * 错误原因：因为收到Java中hashMap添加元素的拉链法的干扰，导致对问题抽象建模错误
 * 改进：由于1 <= capacity <= 3000，所以使用一条双向链表加HashMap，双向链表用于删除最少使用元素，HashMap用于快速定位元素
 *
 * @author hxcoder
 */
public class LRUCache {

    /**
     * Java HashMap
     */
    HashMap<Integer, LinkedList<Integer>> map;

    /**
     * Java LinkedList
     */
    LinkedList<Integer> list;

    /**
     * 各个链表存储元素数量和
     */
    int sums = 0;

    int limit;

    public static void main(String[] args) {

    }

    public LRUCache(int capacity) {
        limit = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        int nums = key % limit;
        LinkedList<Integer> list = map.get(nums);
        if (list == null) {
            return -1;
        }
        // 从list中获得value
        return 0;
    }

    public void put(int key, int value) {
        // hash运算，得到该key在第几条链表中
        int nums = key % limit;
        if (map.get(nums) == null) {
            LinkedList<Integer> newList = new LinkedList<>();
            map.put(nums, newList);
        }
        LinkedList<Integer> list = map.get(nums);
        // 链表满，需要删除其他元素
        if (sums >= limit) {
            list.removeLast();
        }
        // 添加元素
        list.add(value);
        map.put(nums, list);
        sums++;
    }
}
