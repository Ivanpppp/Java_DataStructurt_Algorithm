package LeetCode;

import java.util.Arrays;

/**
 *
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 *
 * 注意： x 不必 是 nums 的中的元素。
 *
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,5]
 * 输出：2
 * 解释：有 2 个元素（3 和 5）大于或等于 2 。
 * 示例 2：
 *
 * 输入：nums = [0,0]
 * 输出：-1
 * 解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
 * 如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
 * 如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
 * 如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
 * x 不能取更大的值，因为 nums 中只有两个元素。
 * 示例 3：
 *
 * 输入：nums = [0,4,3,0,4]
 * 输出：3
 * 解释：有 3 个元素大于或等于 3 。
 * 示例 4：
 *
 * 输入：nums = [3,6,7,7,0]
 * 输出：-1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/special-array-with-x-elements-greater-than-or-equal-x
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class No1608 {
    public static void main(String[] args) {
        int[] nums = {3,6,7,7,0};

        System.out.println(specialArray(nums));
    }

    public static int specialArray(int[] nums) {
        // 二分法
        int[] nums1 = nums;
        Arrays.sort(nums1);
        int ans = -1;
        int l = 0,r = nums.length-1;
        while (l < r) {
            int mid = (l + r) / 2;
            int temp = nums1[mid];
            if (temp == mid + 1) {
                ans = temp;
                break;
            }
            if (temp >= mid){
                r = mid - 1;
            }
            if (temp <= mid){
                l = mid + 1;
            }

        }
        return ans;

    }
}
