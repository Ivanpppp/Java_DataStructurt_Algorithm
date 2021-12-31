package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 *
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,6]
 * 输出：1
 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
 * 示例 2：
 *
 * 输入：nums = [3,3,6,4,5]
 * 输出：0
 * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
 * 示例 3：
 *
 * 输入：nums = [1,1,1,3,5]
 * 输出：4
 * 解释：满足要求的 4 个四元组如下：
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-special-quadruplets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No1995 {
    public static void main(String[] args) {

    }

    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        // 用数组来存储nums[d]
        int[] res = new int[10010];
        for (int c = n - 2; c >= 2 ; c--) {
            // c每-1，d就能多取一个（即c的上一个位置）
            res[nums[c+1]]++;
            // 循环遍历a和c
            for (int a = 0; a < c - 1; a++) {
                for (int b = a + 1; b < c; b++) {
                    ans += res[nums[a] + nums[b] + nums[c]];
                }
            }
        }
        return ans;
    }
}
