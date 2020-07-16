package Ivan.Search;

import java.util.*;


//使用二分查找的前提是该数组是有序的
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7, 3, 34, 44, 5, 6, 7, 89, 23, 34, 6, 72, 60};
        Arrays.sort(arr);
        int temp = binarySearch(arr, 43, 0, arr.length - 1);
        System.out.println(temp);
    }

    //二分查找算法

    /**
     * @param arr   需要查找的数组
     * @param n     需要查找的值
     * @param left  左边界
     * @param right 右边界
     * @return 找到返回下标，没找到返回-1
     */
    public static int binarySearch(int[] arr, int n, int left, int right) {
        if (n < arr[left] || n > arr[right] || left > right) {      //判断是否越界
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (midValue < n) {
            return binarySearch(arr, n, mid + 1, right);
        } else if (midValue > n) {
            return binarySearch(arr, n, left, mid - 1);
        } else {
            return mid;
        }

    }
}
