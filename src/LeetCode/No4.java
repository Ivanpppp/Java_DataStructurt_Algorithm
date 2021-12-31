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
        // 中位数的位置应为 (nums1.length + nums2.length) / 2
        int mid = 0;
        int left = 0;
        int right = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        double ans = 0;
        while(left + right != mid){
            int t1 = nums1[left];
            int t2 = nums2[right];
            ans = (t1 + t2) / 2;
            if (t1 > t2){
                right++;
            }else {
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
