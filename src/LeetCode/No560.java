package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class No560 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/subarray-sum-equals-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // 前缀和 + 哈希表
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0,pre = 0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
