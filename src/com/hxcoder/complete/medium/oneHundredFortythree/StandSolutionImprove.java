package com.hxcoder.complete.medium.oneHundredFortythree;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用线性表
 * 收获：List list = new ArrayList(); 底层数据结构是array，可以使用get(index)进行随机访问
 *
 * @author hxcoder
 */
public class StandSolutionImprove {

    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        // 厉害！直接利用arrayList底层数据为array的特点，直接使用get(index)进行随机访问，然后直接进行重排
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
