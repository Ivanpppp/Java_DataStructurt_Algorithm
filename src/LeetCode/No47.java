package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No47 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> ans = new ArrayList<>();
        ans = permuteUnique(nums);
        System.out.println(ans);

    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] vis = new int[nums.length];
        dfs(ans,path,nums,vis);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> path, int[]nums,int[] vis) {
        // 退出递归条件
        if (path.size() == nums.length){
            if (ans.contains(new ArrayList<>(path))) return;
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == 1) continue;
            vis[i] = 1;
            path.add(nums[i]);
            dfs(ans, path, nums, vis);
            vis[i] = 0;
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}
