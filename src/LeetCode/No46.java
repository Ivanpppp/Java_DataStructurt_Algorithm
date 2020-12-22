package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        ans = permute(nums);
        System.out.println(ans);
    }
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        int[] vis = new int[nums.length];
        dfs(nums,ans,path,vis);
        return ans;
    }

    private static void dfs(int[] nums,List<List<Integer>> ans, List<Integer> path,int[] vis) {
        if ( path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == 1) continue;
            vis[i] = 1;
            path.add(nums[i]);
            dfs(nums, ans, path, vis);
            vis[i] = 0;
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}
