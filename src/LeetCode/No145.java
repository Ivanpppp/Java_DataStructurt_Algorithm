package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历
 * 左 --> 右 --> 根
 */
public class No145 {
    List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {

    }
    // 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return ans;
        }
        if(root.left != null){
            postorderTraversal(root.left);
        }
        if(root.right != null){
            postorderTraversal(root.right);
        }
        ans.add(root.val);
        return ans;
    }

    // 迭代
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == prev){
                res.add(node.val);
                prev = node;
                node = null;
            }else {
                stack.push(node);
                node = node.right;
            }

        }
        return res;
    }
}
