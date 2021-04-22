package com.hxcoder.leetcode.hard.oneHundredFortytwo;

import java.util.HashSet;
import java.util.Set;

/**
 * 解题思路：
 * 1.判断是否存在环，已经找出入环点，本质上就是判断一个集合中是否有元素存在重复
 * 即可以使用set——>使用hashSet
 *
 * @author hxcoder
 */
public class StandSolution {

    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
