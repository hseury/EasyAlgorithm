package com.company.leetcode;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode102 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (deque.size() > 0){
//            存放的是每层的结点
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode element= deque.remove();
                level.add(element.val);
                if (element != null) {
                    if (element.left != null) {
                        deque.add(element.left);
                    }
                    if (element.right != null) {
                        deque.add(element.right);
                    }
                }
            }
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        List<List<Integer>> result = levelOrder(root);
        for (List<Integer> level:result) {
            for (Integer node :level){
                System.out.print(node+",");
            }
            System.out.println();
        }
    }
}
