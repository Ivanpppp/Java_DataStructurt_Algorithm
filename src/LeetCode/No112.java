package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No112 {

    // dfs
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum - root.val);
    }

    //bfs
    public boolean hasPathSum2(TreeNode root, int sum) {
        // 用两个队列来存放相关数据
        // 存放节点的值
        Queue<Integer> nodeVal = new LinkedList<>();
        // 存放节点
        Queue<TreeNode> node = new LinkedList<>();

        node.offer(root);
        nodeVal.offer(root.val);

        // 开始循环
        while (!node.isEmpty()){
            // 出队
            TreeNode cur = node.poll();
            int temp = nodeVal.poll();
            if (cur.left == null && cur.right == null){
                if (sum == temp){
                    return true;
                }
                continue;
            }
            if (cur.left!=null){
                node.offer(cur.left);
                nodeVal.offer(cur.left.val + temp);
            }
            if (cur.right!=null){
                node.offer(cur.right);
                nodeVal.offer(cur.right.val + temp);
            }


        }
        return false;
    }
}
