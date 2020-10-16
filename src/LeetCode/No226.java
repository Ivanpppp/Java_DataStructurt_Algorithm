package LeetCode;
/*
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/invert-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No226 {
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
    // 直接dfs即可
    public TreeNode invertTree(TreeNode root) {
        // 退出深搜条件
        if (root == null){
            return null;
        }
        // 递归左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // 进行交换
        root.left = right;
        root.right = left;
        //返回
        return root;
    }
}
