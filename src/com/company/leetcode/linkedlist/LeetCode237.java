package com.company.leetcode.linkedlist;

import com.company.PrintUtil;
import com.company.leetcode.ListNode;

/**
 *
 *请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 */
public class LeetCode237 {
  public static void deleteNode(ListNode node) {
    //无法找到前一个节点
    node.val = node.next.val;
    node.next = node.next.next;
  }
  public static void main(String[] args) {
    ListNode root = new ListNode(4);
    root.next = new ListNode(5);
    root.next.next = new ListNode(1);
    root.next.next.next = new ListNode(9);

    PrintUtil.printListNode(root);
    deleteNode(root.next);
    PrintUtil.printListNode(root);
  }

}
