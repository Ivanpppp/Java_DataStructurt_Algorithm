package LeetCode;

import java.util.*;

/*
    给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No107 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        // 答案
        List<List<Integer>> ans = new LinkedList<>();

        // 特判
        if (root == null){
            return ans;
        }

        //用一个队列来存储
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            // 用一个list来存放每一层的节点的值
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            // 每一层结束后，将本层的值加入到ans中,由于题目要求，每次都应放在最上层
            ans.add(0,list);

        }
        return ans;
    }
}
