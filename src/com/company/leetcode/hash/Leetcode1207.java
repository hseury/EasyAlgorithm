package com.company.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 * @link https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
public class Leetcode1207 {

  public static boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    int length = arr.length;
    for (int i = 0; i < length; i++) {
      Integer value = map.get(arr[i]);
      if (value != null) {
        value++;
        map.put(arr[i],value);
      } else {
        map.put(arr[i], 1);
      }
    }

    HashSet<Integer> set = new HashSet<>();
    for (Integer element : map.values()) {
      if (!set.add(element)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 2, 1, 1, 3};
    System.out.println(uniqueOccurrences(arr));

    int[] arr1 = new int[]{1, 3,3,1};
    System.out.println(uniqueOccurrences(arr1));
  }
}
