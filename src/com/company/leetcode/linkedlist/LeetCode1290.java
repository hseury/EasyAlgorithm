package com.company.leetcode.linkedlist;

import com.company.leetcode.ListNode;

public class LeetCode1290 {
  public static int getDecimalValue(ListNode head) {
    int result = 0;
    while (head != null){
      result = 2 * result + head.val;
      head = head.next;
    }
    return result;
  }

  public static void main(String[] args) {
    ListNode root = new ListNode(1);
    root.next = new ListNode(0);
    root.next.next = new ListNode(1);
    System.out.println(getDecimalValue(root));
  }

}
