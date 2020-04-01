package com.company.leetcode;

import java.util.List;

public class Leetcode21 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0);
        ListNode headPrev = current;

        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            }else{
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            current.next = l2;
        }

        if (l2 == null) {
            current.next = l1;
        }

        return headPrev.next;
    }

    public static void main(String[] args) {
        // write your code here
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(4);
        node11.next = node12;
        node12.next = node13;
        node13.next = null;

        printListNode(node11);

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;
        node23.next = null;

        printListNode(node21);

        ListNode newHead = mergeTwoLists(node11,node21);
        printListNode(newHead);
    }

    public static void printListNode(ListNode header) {
        System.out.print("[");
        while (header != null) {
            if (header.next != null) {
                System.out.print(header.val + ",");
            } else {
                System.out.print(header.val);
            }
            header = header.next;
        }
        System.out.print("]");
    }
}
