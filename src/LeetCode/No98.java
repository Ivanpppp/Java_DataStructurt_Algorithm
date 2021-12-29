package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 验证二叉搜索树
 *      二叉搜索树： 左节点 < 根节点 < 右节点
 * 中序遍历即可
 */
public class No98 {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        if (root.val <= pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    // 递归 -- 比较复杂的写法了
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST2(TreeNode root) {
        inorder(root);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i - 1) >= list.get(i)){
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        inorder(treeNode.left);
        list.add(treeNode.val);
        inorder(treeNode.right);
    }
}
