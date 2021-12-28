package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No144 {
    public static void main(String[] args) {

    }
    // 前序遍历：根 --> 左 --> 右
    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    // 递归
    public static void dfs(TreeNode root,List<Integer> list){
        // 中止条件
        if (root == null){
            return;
        }
        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
    }

    //迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                ans.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return ans;

    }
}
