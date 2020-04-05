package com.company.sort;

public class Sort {

  enum SORT_TYPE {
    BUBBLE, INSERT, MERGE, QUICK, HEAP
  }

  private static int[] heapSort(int[] nums) {
    int[] result = new int[nums.length + 1];
    result[0] = 0;
    //首位为空的数组
    for (int i = 0; i < nums.length; i++) {
      result[i + 1] = nums[i];
    }
    //构造堆有序
    int N = nums.length;
    for (int i = N / 2; i >= 1; i--) {
      sink(result, i, N);
    }
    //下沉堆排序
    while (N > 1) {
      swap(result, 1, N--);
      sink(result, 1, N);
    }
    printArray(result);
    //去掉首位的数据
    for (int i = 0; i < nums.length; i++) {
      nums[i] = result[i + 1];
    }
    return nums;
  }

  /**
   * 保证k节点和最后一个节点交换后，去掉最后一个节点（即原来的k节点） 留下的堆还是有序的
   *
   * @param array
   * @param k
   * @param N
   */
  private static void sink(int[] array, int k, int N) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && less(array, j, j + 1)) {
        j++;
      }
      //经过此步骤，j为子堆中较大的数
      if (!less(array, k, j)) {
        //如果父节点大于子节点，退出循环
        break;
      }
      swap(array, k, j);
      k = j;
    }
  }

  private static boolean less(int[] array, int i, int j) {
    return array[i] < array[j];
  }

  /**
   * 快速排序 quickSort 时间复杂度 o(NlogN) 空间复杂度 取决于递归的次数 log
   *
   * @param nums
   * @return
   */
  private static int[] quickSort(int[] nums) {
    return nums;
  }

  /**
   * 归并排序 merge sort 有额外空间开销 复杂度 o(NlogN)
   *
   * @param nums
   * @return
   */
  private static int[] mergeSort(int[] nums) {
    int[] result = new int[nums.length];
    mergeSort(result, nums, 0, nums.length - 1);
    return nums;
  }

  private static void mergeSort(int[] result, int[] aux, int low, int high) {
    if (high <= low) {
      return;
    }

    int mid = low + (high - low) / 2;
    mergeSort(result, aux, low, mid);
    mergeSort(result, aux, mid + 1, high);
    merge(result, aux, low, mid, high);
  }

  private static void merge(int[] result, int[] a, int low, int mid, int high) {
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
   * 冒泡排序 bubbleSort o(n2)
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

  private static void printArray(String content, int[] nums) {
    System.out.print(content);
    printArray(nums);
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
    int[] result = sort(nums, SORT_TYPE.HEAP);
    printArray(result);

    int[] answer = new int[]{1, 3, 5, 21, 62, 64, 66, 73};
    assert (result == answer);
  }
}
