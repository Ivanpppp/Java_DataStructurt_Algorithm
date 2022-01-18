package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        ans = subsets2(nums);

    }
    // 首先可以考虑迭代的方式
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 先添加一个空集
        ans.add(new ArrayList<>());
        for (int num : nums) {
            for (int i = 0,j = ans.size(); i < j ; i++) {
                List<Integer> list = new ArrayList<>(ans.get(i));
                list.add(num);
                ans.add(list);
            }
        }
        return ans;
    }

    // 递归也是可以求解
    public static List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),nums,0);
        return res;
    }

    public static void dfs(List<List<Integer>> ans,List<Integer> temp,int[] nums,int cur){
        ans.add(new ArrayList<>(temp));
        for (int i = cur; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(ans,temp,nums,i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
