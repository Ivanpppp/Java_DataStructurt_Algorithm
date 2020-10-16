package LeetCode;

/*
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

 

例如：

输入: 原始二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No538 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        // 反向中序遍历
        if (root!=null){
            // 右子树
            convertBST(root.right);
            // 更新节点值
            sum+=root.val;
            root.val = sum;
            //左子树
            convertBST(root.left);
        }
        return root;
    }
}
