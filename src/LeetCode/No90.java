package LeetCode;

import java.util.*;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class No90 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> ifExists = new HashSet<>();
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        for (int num :
                nums) {
            int n = ans.size();
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<>(ans.get(i));
                list.add(num);
                if (!ifExists.contains(list)){
                    ans.add(list);
                    ifExists.add(list);
                }
            }
        }
        return ans;
    }





}
