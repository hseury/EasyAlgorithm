package com.company.leetcode;

import com.company.ArrayTools;

public class LeetCode189 {
    public static void rotate(int[] nums, int k) {
        int[] current = new int[k];
        int leng = nums.length;
        k %= leng;
        for (int i = 0; i < k; i++) {
            current[i] = nums[leng - k + i];
        }
        for (int i = (leng - 1); i > k - 1; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = current[i];
        }
    }

    public static void main(String[] args) {
        // write your code here
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayTools.print(nums);
        rotate(nums, 2);
        ArrayTools.print(nums);
    }


}
