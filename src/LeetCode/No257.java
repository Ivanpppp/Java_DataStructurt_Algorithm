package LeetCode;


import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明:叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No257 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        dfs(root,"",ans);
        return ans;
    }
    public static void dfs(TreeNode root,String path,List<String> paths){
        if (root!=null){
            StringBuffer stringBuffer = new StringBuffer(path);
            stringBuffer.append(Integer.toString(root.val));
            if (root.left==null && root.right == null){
                paths.add(stringBuffer.toString());
            }else {
                stringBuffer.append("->");
                dfs(root.left,stringBuffer.toString(),paths);
                dfs(root.right,stringBuffer.toString(),paths);
            }
        }
    }
    public static void main(String[] args) {
    }
}
