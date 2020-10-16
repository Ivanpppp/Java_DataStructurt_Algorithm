package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。


示例 1：

输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 

提示：

节点值的范围在32位有符号整数范围内。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No637 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<Double>();
        // 特判
        if (root == null){
            return list;
        }
        // 对其进行层序遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // 如果不为空的时候进行循环
        while(!queue.isEmpty()){
            // 每层的一个宽度
            int size = queue.size();
            // 用于保存每层的节点的值的和
            double ans = 0;
            for (int i = 0; i < size; i++) {
                // 出队
                TreeNode cur = queue.poll();
                ans+=cur.val;
                // 如果当前出队的节点左子树不为空，加入队列中
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                // 如果当前出队的节点右子树不为空，加入队列中
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            double cur_ans = ans/size;
            list.add(cur_ans);
        }
        return list;
    }
}
