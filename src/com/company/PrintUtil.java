package com.company;

import com.company.leetcode.ListNode;

public class PrintUtil {
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
