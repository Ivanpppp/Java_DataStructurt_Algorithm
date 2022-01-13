package LeetCode;

import java.util.Arrays;

/*
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

 

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No4 {
    // 有问题
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并两个数组，找中位数
        int n = nums1.length;
        int m = nums2.length;
        int n1 = 0,n2 = 0,index = 0;
        int[] nums3 = new int[m+n];
        while (n1 <= n - 1|| n2 <= m - 1){
            if (nums1[n1] < nums2[n2]){
                nums3[index] = nums1[n1];
                if (n1 < n - 1) {
                    n1++;
                }
            }else if(nums1[n1] >= nums2[n2]){
                nums3[index] = nums2[n2];
                if (n2 < m - 1){
                    n2++;
                }
            }
            index++;
        }
        if (( n + m )% 2 != 0){
            return nums3[(n+m)/2];
        }
        else {
            return (nums3[(n+m)/2 - 1] + nums3[(n+m)/2]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
