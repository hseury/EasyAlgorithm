package com.company.leetcode;

import com.company.ArrayTools;

public class LeetCode189 {
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k >= length) {
            return;
        }

        int[] a = new int[k];
        int[] b = new int[length - k];

        for (int i = 0; i < k; i++) {
            a[i] = nums[length - k + i];
        }
        for (int j = 0; j < length - k; j++) {
            b[j] = nums[j];
        }

        for (int l = 0; l < length; l++) {
            if (l < k) {
                nums[l] = a[l];
            } else {
                nums[l] = b[l - k];
            }
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
