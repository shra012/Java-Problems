package com.shrvn.leetcode.medium.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SortedMerge {

    public static void main(String[] args) {
        SortedMerge sol = new SortedMerge();
//        ListNode l1 = new ListNode(-9, new ListNode(3));
//        ListNode l2 = new ListNode(5, new ListNode(7));

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(4)));
        System.out.println(sol.mergeTwoLists(l1, l2));
    }

    /**
     * Definition for singly-linked list.
     * Example :
     * [1,2,4]
     * [1,3,4]
     * Loop 1 :
     * l1 [2,4]
     * head [1,3,4]
     * l2 [1,1,3,4]
     * Loop 2:
     * l1 [4]
     * head [2,3,4]
     * l2 [1,1,2,3,4]
     * Loop 3:
     * l1 [4]
     * head [3,4]
     * l2 [1,1,2,3,4]
     * Loop 4:
     * l1 []
     * head [4]
     * l2 [1,1,2,3,4,4]
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        l1 = l1.next;
        ListNode current = l2;
        ListNode currentNext = l2.next;
        while(l1 != null){
            if (l1.val > current.val) {
                current = new ListNode(l1.val, currentNext);
            } else {
                current.next = new ListNode(l1.val, currentNext);
            }
            current = current.next;
            currentNext = currentNext.next;
            l1 = l1.next;
        }
        return l2;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode head = this;
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            return list.toString();
        }
    }
}
