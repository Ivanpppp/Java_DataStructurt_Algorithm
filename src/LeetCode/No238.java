package LeetCode;

public class No238 {
    /**
     * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
     *
     * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
     *
     * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
     *
     * 
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     * 示例 2:
     *
     * 输入: nums = [-1,1,0,-3,3]
     * 输出: [0,0,9,0,0]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/product-of-array-except-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        // 维护两个数组L[] R[]分别表示左右侧的乘积，最终要得到的数据则为L[i] * R[i]
        int n = nums.length;
        int[] L = new int[n], R = new int[n], ans = new int[n];
        L[0] = 1;
        R[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }
}
