package LeetCode;

import java.util.*;

/*
    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 */
public class No77 {
    public static void main(String[] args) {

    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,1);
        return ans;
    }

    public void dfs(int n, int k, int index) {
        int size = list.size();
        // 结束条件
        if (size == k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n ; i++) {
            list.add(i);
            dfs(n,k,i+1);
            // 回溯。需要删除最后的不合规的
            list.remove(list.size() - 1);
        }
    }
}
