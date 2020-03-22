package com.company.sort;

public class Sort {
    enum SORT_TYPE {
        BUBBLE, INSERT, MERGE, QUICK, HEAP
    }

    private static int[] heapSort(int[] nums) {
//        int result
        return nums;
    }

    /**
     * 快速排序
     * quickSort
     * 时间复杂度 o(NlogN)
     * 空间复杂度 取决于递归的次数 log
     *
     * @param nums
     * @return
     */
    private static int[] quickSort(int[] nums) {
        return nums;
    }

    /**
     * 归并排序
     * merge sort
     * 有额外空间开销
     * 复杂度 o(NlogN)
     *
     * @param nums
     * @return
     */
    private static int[] mergeSort(int[] nums) {
        return nums;
    }

    /**
     * 插入排序
     *
     * @param nums
     * @return
     */
    private static int[] insertSort(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums;
        }

        int nxtFirstIndex = 1;
        for (int i = nxtFirstIndex; i < length; i++) {
            int j;
            int tmp = nums[i];
            for (j = i - 1; j >= 0 && nums[j] > tmp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = tmp;
        }

        return nums;
    }

    /**
     * 冒泡排序
     * bubbleSort
     * o(n2)
     *
     * @param nums
     * @return
     */
    private static int[] bubbleSort(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    private static int[] sort(int[] nums, SORT_TYPE type) {
        switch (type) {
            case BUBBLE:
                return bubbleSort(nums);
            case INSERT:
                return insertSort(nums);
            case MERGE:
                return mergeSort(nums);
            case QUICK:
                return quickSort(nums);
            case HEAP:
                return heapSort(nums);
            default:
                return nums;
        }
    }

    private static void printArray(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                System.out.print("[ " + nums[i] + ",");
            } else if (i == length - 1) {
                System.out.print(nums[i] + "]\n");
            } else {
                System.out.print(nums[i] + ",");
            }
        }
    }

    public static void main(String[] args) {
        // write your code here
        int[] nums = new int[]{3, 5, 1, 64, 62, 66, 73, 21};
        printArray(nums);
        int[] result = sort(nums, SORT_TYPE.BUBBLE);
        printArray(result);

        int[] answer = new int[]{1, 3, 5, 21, 62, 64, 66, 73};
        assert (result == answer);
    }
}
