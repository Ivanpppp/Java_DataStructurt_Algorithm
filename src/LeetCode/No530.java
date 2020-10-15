package LeetCode;
/*
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

 

示例：

输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No530 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }
    public static void main(String[] args) {

    }
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE; //赋最大值
        pre = -1;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        // 左根右 —— 中序遍历
        dfs(root.left);
        if (pre == -1){
            pre = root.val;
        }else {
            ans = Math.min(ans,Math.abs(pre-root.val));
            pre = root.val;
        }
        dfs(root.right);
    }
}
