package LeetCode;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No16 {
    public static void main(String[] args) {

    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            if (i > 0 && a == nums[i-1]){
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + a;
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
                if (sum > target){
                    int r0 = r - 1;
                    while (r0 > l && nums[r0] == nums[r]){
                        r0--;
                    }
                    r = r0;
                }else {
                    int l0 = l + 1;
                    while (l0 < r && nums[l0] == nums[l]){
                        l0++;
                    }
                    l = l0;
                }
            }
        }
        return ans;
    }
}
