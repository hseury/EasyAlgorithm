package com.company.leetcode.linkedlist;

import com.company.PrintUtil;
import com.company.leetcode.ListNode;

public class Leetcode24 {
  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null){
      return head;
    }

    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;

    return newHead;
  }

  public static void main(String[] args) {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(4);
    root.next.next.next.next = new ListNode(5);

    PrintUtil.printListNode(root);
    PrintUtil.printListNode(reverseList(root));
  }
}
