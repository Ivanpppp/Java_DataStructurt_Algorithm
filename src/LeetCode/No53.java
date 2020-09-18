package LeetCode;

/*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums){
        // 动态规划
        int n = nums.length;
        // 用一个pre来表示前面的值
        int pre = nums[0];
        // 维护一个最大值max
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            // pre 维护的是 前面最大的一个数据，如果当前的数据和pre的和比nums[i]更小，就将其更新为nums[i]
            pre = Math.max(nums[i],pre + nums[i]);
            max = Math.max(pre,max);
        }
        return max;
    }
}
