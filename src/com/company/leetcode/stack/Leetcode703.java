package com.company.leetcode.stack;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode703 {

  public static class KthLargest {

    private PriorityQueue<Integer> queue;
    private int limit;

    public KthLargest(int k, int[] nums) {
      limit = k;
      queue = new PriorityQueue<>(k, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
         /* Compares its two arguments for order.  Returns a negative integer,
      zero, or a positive integer as the first argument is less than, equal
      to, or greater than the second.*/
          return o1.intValue() - o2.intValue();
        }
      });
      for (int i : nums) {
        add(i);
      }
    }

    public int add(int val) {
      if (queue.size() < limit) {
        queue.add(val);
      } else if (val > queue.peek()) {
        queue.poll();
        queue.add(val);
      }
      return queue.peek();
    }
  }

  public static void main(String[] args) {
    int[] aar = new int[]{4, 5, 8, 2};
    KthLargest largest = new KthLargest(3, aar);
    System.out.println(largest.add(3));
    System.out.println(largest.add(5));
    System.out.println(largest.add(10));
    System.out.println(largest.add(9));
    System.out.println(largest.add(4));

  }
}
