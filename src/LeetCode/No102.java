package LeetCode;

import java.util.*;

/**
 * 二叉树的层序遍历
 */
public class No102 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层序遍历root
        while (!queue.isEmpty()){
            int n = queue.size(); //判断该层有多少节点
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
