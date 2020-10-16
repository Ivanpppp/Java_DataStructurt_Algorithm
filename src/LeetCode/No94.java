package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No94 {
    public static void main(String[] args) {

    }
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    // 用一个List存放答案
    List<Integer> ans = new ArrayList<>();
    // 递归的方法
    public List<Integer> inorderTraversal(TreeNode root) {
        // 特判
        if (root == null){
            return ans;
        }

        // 根据左右根的方法递归
        if (root.left!=null){
            inorderTraversal(root.left);
        }
        // 如果当前节点不为空，加入ans里
        if (root!=null){
            ans.add(root.val);
        }
        if (root.right!=null){
            inorderTraversal(root.right);
        }
        return ans;
    }

    // 迭代的方法
    public List<Integer> inorderTraversal2(TreeNode root){
        // 迭代的关键是维护栈
        // 存放答案的List
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        // 特判
        if (root == null){
            return list;
        }

        //开始递归，循环条件——root不为空或者栈不为空即可
        while (root != null || !stack.isEmpty()){
            // 由中序遍历顺序可知，先把所有的左节点加入栈中，没有时再出栈
            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            // 当走到最左边的节点的时候，将其出栈
            root = stack.pop();
            // 加入到结果集
            list.add(root.val);
            // 如果当前的root有右节点，令root为由节点，再回到循环体中的while去找当前子树的左节点
            root = root.right;
        }
        return list;
    }

}
