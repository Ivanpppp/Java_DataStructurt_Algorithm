package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No113 {
    public static void main(String[] args) {

    }

    // 最终结果
    List<List<Integer>> ans = new LinkedList<>();
    //用于存储当前的节点值的队列
    Deque<Integer> queue = new LinkedList<>();
    // 直接进行深度优先搜索即可
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null){
            return;
        }
        queue.add(root.val);
        sum-=root.val;
        if (root.left == null && root.right == null && sum == 0){
            ans.add(new LinkedList<>(queue));
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        // 进行回溯
        queue.pollLast();
    }
}
