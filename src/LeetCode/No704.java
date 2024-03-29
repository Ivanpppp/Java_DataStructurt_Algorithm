package LeetCode;

import java.util.Arrays;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No704 {
    public static void main(String[] args) {
        int[] nums = {5};
        System.out.println(search(nums,5));
    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right){
            int mid = nums[(right+left) / 2];
            if (mid < target){
                left = (right+left) / 2 + 1;
            }else if (mid > target){
                right = (right+left) / 2 - 1;
            }else {
                ans = (right+left) / 2;
                break;
            }
        }
        return ans;
    }

}
