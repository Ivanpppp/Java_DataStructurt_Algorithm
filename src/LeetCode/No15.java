package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No15 {

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> ans = threeSum(nums);
        System.out.println(ans);
    }


    // 排序 + 双指针
    public static List<List<Integer>> threeSum(int[] nums) {
        // 存放答案的ans
        List<List<Integer>> ans = new LinkedList<>();
        // 首先先对数组进行排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 判定有没有重复
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // 枚举a
            int a = nums[i];

            // 最右边的指针
            int third = n - 1;
            // 本次循环的list

            for (int j = i + 1; j < n; j++) {
                // 要和上一个数不一样
                if (j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                List<Integer> list = new LinkedList<>();
                while ( j < third && nums[j]+nums[third] > -a){
                    third--;
                }
                // 如果两个指针重合，退出
                if (j == third){
                    break;
                }
                // 枚举b
                if (nums[j] + nums[third] == -a){
                    list.add(a);
                    list.add(nums[j]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
