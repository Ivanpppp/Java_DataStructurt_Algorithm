package LeetCode;

/**
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 *
 * 返回 nums 中 所有 子数组范围的 和 。
 *
 * 子数组是数组中一个连续 非空 的元素序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-subarray-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No2104 {
    /**
     * 暴力枚举即可
     *
     *  实现O(n)复杂度的话需要实现一个单调栈
     * @param nums
     * @return
     */
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
