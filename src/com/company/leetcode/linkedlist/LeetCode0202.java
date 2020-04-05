package com.company.leetcode.linkedlist;

import com.company.leetcode.ListNode;

public class LeetCode0202 {

  public static int kthToLast(ListNode head, int k) {
    ListNode first = head;

    while (k-- > 0){
      first = first.next;
    }

    while (first != null){
      first = first.next;
      head = head.next;
    }
    return head.val;
  }

  public static void main(String[] args) {
    ListNode root = new ListNode(1);
//    root.next = new ListNode(2);
//    root.next.next = new ListNode(3);
//    root.next.next.next = new ListNode(4);
//    root.next.next.next.next = new ListNode(5);

    System.out.println(kthToLast(root, 1));

  }

}
