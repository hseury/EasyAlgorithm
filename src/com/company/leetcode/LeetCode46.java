package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            List<Integer> line = new ArrayList<>();
            line.add(nums[i]); //第一步是
        }

        return result;
    }

    public static void print(List<List<Integer>> result) {
        if(result == null || result.size() == 0){
            return;
        }
        for (List<Integer> line : result) {
            for (Integer row : line) {
                System.out.print(row + ", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] nums =new int[] {1,2,3};
        print(permute(nums));
    }
}
