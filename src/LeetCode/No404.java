package LeetCode;

import Ivan.recursion.Queen8;

import java.util.LinkedList;
import java.util.Queue;

/*
计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-left-leaves
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No404 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public static void main(String[] args) {

    }
    // 递归遍历
    public int sumOfLeftLeavesRecursion(TreeNode root){
        // 特判
        if (root == null){
            return 0;
        }

        return dfs(root);
    }

    private int dfs(TreeNode root) {
        int ans = 0;
        if (root.left!=null){
            if (isLeafNode(root.left)){
                ans += root.left.val;
            }else {
                ans += dfs(root.left);
            }
        }
        if (root.right != null){
            ans += dfs(root.right);
        }
        return ans;
    }

    // 层序遍历
    public int sumOfLeftLeaves(TreeNode root) {
        // 特判
        if (root == null){
            return 0;
        }
        // 用一个队列储存
        Queue<TreeNode> queue = new LinkedList<>();

        // 入队root
        queue.offer(root);

        // 结果
        int sum = 0;

        //迭代
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left!=null){
                if (isLeafNode(cur.left)){
                    sum+=cur.left.val;
                }else {
                    queue.offer(cur.left);
                }
            }
            if (cur.right!=null){
                if (!isLeafNode(cur.right)){
                    queue.offer(cur.right);
                }
            }
        }
        return sum;
    }

    public boolean isLeafNode(TreeNode root){
        if (root.right == null && root.left == null){
            return true;
        }
        return false;
    }
}
