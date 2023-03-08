package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 *  
 *
 * 示例 1 ：
 *
 * 输入：nums = [2,2,1]
 * 输出：1
 * 示例 2 ：
 *
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 示例 3 ：
 *
 * 输入：nums = [1]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No136 {
    /**
     * 使用Map，查找到只存在一次的数字
     * 时间复杂度O(n)，空间O(n)
     * @param nums
     * @return
     */
    public int singleNumber(int[]  nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int n :
                nums) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for (int n :
                map.keySet()) {
            int count = map.get(n);
            if(count == 1){
                return n;
            }
        }
        return -1;
    }

    /**
     * 使用 异或的方法
     * 0和x异或为x,x和x异或为0
     * 异或满足交换律
     * @param nums
     * @return
     */
    public int singleNumber2(int[]  nums){
        int ans = 0;
        for (int n :
                nums) {
            ans = ans ^ n;
        }
        return ans;

    }

}
