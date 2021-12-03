package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：

选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
重复这个过程恰好 k 次。可以多次选择同一个下标 i 。

以这种方式修改数组后，返回数组 可能的最大和 。

 

示例 1：

输入：nums = [4,2,3], k = 1
输出：5
解释：选择下标 1 ，nums 变为 [4,-2,3] 。
示例 2：

输入：nums = [3,-1,0,2], k = 3
输出：6
解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
示例 3：

输入：nums = [2,-3,-1,5,-4], k = 2
输出：13
解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No1005 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,-3,-1,5,-4};
        System.out.println(largestSumAfterKNegations2(nums,2));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            Arrays.sort(nums);
            // 最小的取反
            nums[0] = -nums[0];
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
        }
        return ans;
    }

    public static int largestSumAfterKNegations2(int[] nums, int k) {
        int ans = Arrays.stream(nums).sum();
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        // 遍历负数，如果有负数则反转，使最终结果变大
        for (int i = -100; i < 0; i++) {
            // 如果map中有值为i的key
            if (map.containsKey(i)){
                // ops为反转次数，如果map中有n个负数，且n < k，则都可以反转
                int ops = Math.min(k,map.get(i));
                // 反转一个则相当于加上两倍的数值
                ans += ops * 2 * -i;
                // 维护map,把反转后的值放进map中
//                map.put(i,map.get(i) - ops);
                map.put(-i,map.getOrDefault(-i,0) + ops);
                // 维护k
                k -= ops;
            }
            if (k == 0) break;
        }
        // 如果k不为0，且k不为偶数，且map中没有值为0的key，则开始从(0,100]进行反转，反转最小的数后即可返回答案（因为奇数k翻转一次后变偶数）
        if (k > 0 && k%2 != 0 && !map.containsKey(0))
        {
            for (int i = 1; i <= 100; i++) {
                if (map.containsKey(i)) {
                    ans -= i * 2;
                    break;
                }

            }
        }
        return ans;
    }
}
